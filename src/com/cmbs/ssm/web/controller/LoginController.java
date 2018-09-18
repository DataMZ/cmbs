package com.cmbs.ssm.web.controller;

import com.cmbs.ssm.pojo.Account;
import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.service.AccountService;
import com.cmbs.ssm.service.OperatorService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: zwc
 * @date: 2018/9/4 9:42
 * @description: 登录验证和登录跳转的功能
 */
@Controller
public class LoginController {
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(HttpSession session, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Object accountClass = session.getAttribute("accountClass");
        JSONObject jsonObject = new JSONObject();
        if(accountClass != null) {
            jsonObject.put("status","accountAgn");
            return jsonObject.toString();
        }else {
            String rights = httpServletRequest.getParameter("rights");
            String userName = httpServletRequest.getParameter("userName");
            String passwd = httpServletRequest.getParameter("passwd");
            if(rights == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/login.html");
                return "";
            }else {
                // {"status": "accountErr"/ "accountRgt"}
                if(rights.equals("0") || rights.equals("1")) {
                    if(operatorService.loginCheck(rights,userName,passwd)) {
                        Operator operator = operatorService.queryOperatorById(userName);
                        session.setAttribute("account",operator);
                        session.setAttribute("accountClass","Operator");
                        if(operator.getIsAdmin().equals("Y")) {
                            session.setAttribute("indexPage",httpServletRequest.getContextPath()+"/admin/index.jsp");
                        }else {
                            session.setAttribute("indexPage",httpServletRequest.getContextPath()+"/operator/index.jsp");
                        }
                        jsonObject.put("status","accountRgt");
                    }else {
                        jsonObject.put("status","accountErr");
                    }
                }  else {
                    if(accountService.loginCheck(userName)) {
                        session.setAttribute("account",accountService.queryAccountById(userName));
                        session.setAttribute("accountClass","Account");
                        session.setAttribute("indexPage",httpServletRequest.getContextPath()+"/user/index.jsp");
                        jsonObject.put("status","accountRgt");
                    }else {
                        jsonObject.put("status","accountErr");
                    }
                }
                return jsonObject.toString();
            }
        }
    }

    @RequestMapping("/logDispatcher")
    public String loginDispatcher(HttpSession session, HttpServletResponse httpServletResponse) throws IOException {
        String accountClass = (String) session.getAttribute("accountClass");
        if(accountClass.equals("Operator")) {
            Operator account = (Operator) session.getAttribute("account");
            if(account.getIsAdmin().equals("Y")) {
                return "redirect:/admin/index.jsp";
            }else {
                return "redirect:/operator/index.jsp";
            }
        }else {
            return "redirect:/user/index.jsp";
        }
    }

}
