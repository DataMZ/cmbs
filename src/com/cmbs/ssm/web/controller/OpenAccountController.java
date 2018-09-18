package com.cmbs.ssm.web.controller;

import com.cmbs.ssm.pojo.Account;
import com.cmbs.ssm.pojo.Customer;
import com.cmbs.ssm.pojo.Mobile;
import com.cmbs.ssm.pojo.User;
import com.cmbs.ssm.service.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/8 14:27
 * @description:
 */


@Controller
public class OpenAccountController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private MobileService mobileService;
    @Autowired
    private ChargeRuleService chargeRuleService;


    @RequestMapping("/checkId")
    @ResponseBody
    public String checkId(Customer customer, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String idNumber = customer.getIdNumber();
        String idType = customer.getIdType();
        if((idType.equals("0") && !customerService.idCardCodeVerify(idNumber) )||
                (idType.equals("1") && !customerService.officerCardCodeVerify(idNumber)) ||
                (idType.equals("2") && !customerService.passportCardCodeVerify(idNumber))) {
            jsonObject.put("status","idErr");
        }else {
            Customer customerTmp = customerService.queryByIdTypeAndNum(customer);
            if(customerTmp == null) {
                customerTmp = new Customer();
                customerTmp.setIdType(customer.getIdType());
                customerTmp.setIdNumber(customer.getIdNumber());
                customerTmp = customerService.setIdCardName(customerTmp);
                session.setAttribute("customerStatus", "inexistence");
            }else {
                customerTmp = customerService.setDateFormat(customerTmp);
                customerTmp = customerService.setIdCardName(customerTmp);
                session.setAttribute("customerStatus", "exist");
            }
            session.setAttribute("customer",customerTmp);
            jsonObject.put("status","idRgt");
        }
        return jsonObject.toString();
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public String addCustomer(Customer customer,HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String customerStatus = (String)session.getAttribute("customerStatus");
        if(customerStatus.equals("exist")) {
            if(customerService.updateByIdTypeAndNum(customer)){
                jsonObject.put("status","customerRgt");
                Customer customerTmp = customerService.queryByIdTypeAndNum(customer);
                session.setAttribute("customer",customerTmp);
            }else {
                jsonObject.put("status","customerErr");
            }
        }else {
            if(customerService.addCustomer(customer)){
                jsonObject.put("status","customerRgt");
                Customer customerTmp = customerService.queryByIdTypeAndNum(customer);
                session.setAttribute("customer",customerTmp);
            }else {
                jsonObject.put("status","customerErr");
            }
        }
        return jsonObject.toString();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user,HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        List<Mobile> mobiles = mobileService.queryByIsAviable();
        boolean isAviaTel = userService.verifyTelAviable(mobiles, user.getMobileNumber());
        if(!isAviaTel) {
            jsonObject.put("status","telErr");
        }else {
            Mobile mobile = new Mobile();
            mobile.setMobileNumber(user.getMobileNumber());
            session.setAttribute("mobile",mobile);
            jsonObject.put("status","rgt");
            session.setAttribute("user",user);
            Account account = accountService.queryAccountById(String.valueOf(user.getAccountId()));
            if(account == null) {
                account = new Account();
                account.setAccountId(user.getAccountId());
                session.setAttribute("accountTmpStatus","inexistence");
                session.setAttribute("accountTmp",account);
            }else {
                session.setAttribute("accountTmpStatus","exist");
                session.setAttribute("accountTmp",account);
            }
        }
        return jsonObject.toString();
    }

    @RequestMapping("/submit")
    @ResponseBody
    public String submit(Account account,HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String accountTmpStatus = (String) session.getAttribute("accountTmpStatus");
        User user = (User) session.getAttribute("user");
        account.setContactBalance(account.getContactBalance()-chargeRuleService.getFuncFeeById("0"));//减去开户业务费用
        Mobile mobile = (Mobile) session.getAttribute("mobile");
        if(mobileService.updateMobileNotAvai(mobile)) {
            if(accountTmpStatus.equals("inexistence")) {
                if(accountService.addAccount(account)) {
                    jsonObject.put("status","submitRgt");
                    Account accountTmp = accountService.queryAccountByOthers(account);
                    user.setAccountId(accountTmp.getAccountId());
                    userService.addUser(user);
                }else {
                    jsonObject.put("status","submitErr");
                }
            }else {
                if(accountService.updateAccountById(account)) {
                    jsonObject.put("status","submitRgt");
                    userService.addUser(user);
                }else {
                    jsonObject.put("status","submitErr");
                }
            }
        }else {
            jsonObject.put("status","teleErr");
        }
        return jsonObject.toString();
    }


    @RequestMapping("/viewMoreTelNum")
    public String viewMoreTelNum(HttpSession session) {
        List<Mobile> mobiles = mobileService.queryByIsAviable();
        session.setAttribute("mobiles",mobiles);
        return "";
    }
}
