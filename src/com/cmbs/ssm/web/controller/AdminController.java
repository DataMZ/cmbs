package com.cmbs.ssm.web.controller;

import com.cmbs.ssm.mapper.OperatorMapper;
import com.cmbs.ssm.pojo.Charge;
import com.cmbs.ssm.pojo.Operator;
import com.cmbs.ssm.pojo.OperatorVo;
import com.cmbs.ssm.pojo.Page;
import com.cmbs.ssm.service.ChargeRuleService;
import com.cmbs.ssm.service.ChargeService;
import com.cmbs.ssm.service.MobileService;
import com.cmbs.ssm.service.OperatorService;
import com.cmbs.ssm.utils.BusinessMap;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zwc
 * @date: 2018/9/9 22:23
 * @description:
 */

@Controller
public class AdminController {
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private MobileService mobileService;
    @Autowired
    private ChargeService chargeService;
    @Autowired
    private ChargeRuleService chargeRuleService;

    @RequestMapping("/addOperator")
    @ResponseBody
    public String addOperator(Operator operator) {
        JSONObject jsonObject = new JSONObject();
        Operator operatorTmp = operatorService.queryOperatorById(operator.getId());
        if(operatorTmp != null) {
            jsonObject.put("status","accountErr");
        }else {
            operatorService.addOperator(operator);
            jsonObject.put("status","accountRgt");
        }
        return jsonObject.toString();
    }

    @RequestMapping("/addTelephone")
    @ResponseBody
    public String addTelephone(String startTel,String endTel,String telLevel) {
        JSONObject jsonObject = new JSONObject();
        if(mobileService.addMobiles(startTel,endTel,telLevel)) {
            jsonObject.put("status","addRgt");
        }else {
            jsonObject.put("status","addErr");
        }
        return jsonObject.toString();
    }

    @RequestMapping("/addCharge")
    @ResponseBody
    public String addCharge(Charge charge) {
        JSONObject jsonObject = new JSONObject();
        if(chargeService.addOrUpdateCharge(charge)) {
            jsonObject.put("status","addRgt");
        }else {
            jsonObject.put("status","addErr");
        }
        return jsonObject.toString();
    }


    @RequestMapping(value="/addChargeRule", produces = "application/html; charset=utf-8")
    @ResponseBody
    public String addChargeRule(String business, @RequestParam(value="costItem[]") String[] costItem , HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        Charge charge = new Charge();
        List<String> errCostItems = new ArrayList<>();
        boolean isErr = false;
        for (int i = 0; i < costItem.length; i++) {
            charge.setChargeCode(costItem[i]);
            Charge chargeTmp = chargeService.queryChargeByCode(charge);
            if(chargeTmp == null) {
                jsonObject.put("status","addErr");
                errCostItems.add(BusinessMap.getChargeMap().get(costItem[i]));
                isErr = true;
            }
        }
        if(isErr) {
            jsonObject.put("content", "请先创建"+StringUtils.join(new List[]{errCostItems}, ','));
        }else {
            if(chargeRuleService.addOrUpdateChargeRule(business,costItem)) {
                jsonObject.put("status","addRgt");
                jsonObject.put("content", "业务创建成功！");
            }else {
                jsonObject.put("status","addErr");
                jsonObject.put("content", "业务已存在,不需重新创建!");
            }
        }
        return jsonObject.toString();
    }


    @RequestMapping(value="/getCount", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getCount() {
        JSONObject jsonObject = new JSONObject();
        int count = operatorService.queryCount(),countPerPage = 5,pages;
        if(count % countPerPage == 0) {
            pages = count/countPerPage;
        }else {
            pages = count/countPerPage + 1;
        }
        jsonObject.put("first",1);
        jsonObject.put("last",count);
        jsonObject.put("groups",countPerPage);
        jsonObject.put("pages",pages);
        jsonObject.put("count",count);
        return jsonObject.toString();
    }


    @RequestMapping(value="/getOperatorList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getOperatorList(Page page) {
        List<Operator> operators = operatorService.queryOperatorByPage(page);
        JSONArray jsonArray = JSONArray.fromObject(operators);
        return jsonArray.toString();
    }


    @RequestMapping(value="/deleteOperator", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteOperator(String id) {
        JSONObject jsonObject = new JSONObject();
        if(operatorService.deleteOperatorById(id)) {
            jsonObject.put("status","deleteRgt");
        }else {
            jsonObject.put("status","deleteErr");
        }
        return jsonObject.toString();
    }


    @RequestMapping(value="/deleteOperators", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteOperators(@RequestParam(value="ids[]") String[] ids ) {
        JSONObject jsonObject = new JSONObject();
        if(operatorService.deleteOperatorsById(ids)) {
            jsonObject.put("status","deleteRgt");
        }else {
            jsonObject.put("status","deleteErr");
        }
        return jsonObject.toString();
    }


    @RequestMapping(value="/updateOperator", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateOperator( Operator operator) {
        JSONObject jsonObject = new JSONObject();
        if(operatorService.updateOperator(operator)) {
            jsonObject.put("status","updateRgt");
        }else {
            jsonObject.put("status","updateErr");
        }
        return jsonObject.toString();
    }

    @RequestMapping(value="/updateOperatorNoPwd", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateOperatorNoPwd( Operator operator) {
        JSONObject jsonObject = new JSONObject();
        if(operatorService.updateOperatorNoPwd(operator)) {
            jsonObject.put("status","updateRgt");
        }else {
            jsonObject.put("status","updateErr");
        }
        return jsonObject.toString();
    }

    @RequestMapping(value="/searchOperator", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchOperator(Operator operator) {
        JSONObject jsonObject = new JSONObject();
        int count ,countPerPage = 5,pages;
        if(operator.getId().equals("") && !operator.getName().equals("")) {
            count = operatorService.queryCountByName(operator);
        }else if(!operator.getId().equals("") && operator.getName().equals("")) {
            count = operatorService.queryCountById(operator);
        }else {
            count = operatorService.queryCountByIdAndName(operator);
        }
        if(count % countPerPage == 0) {
            pages = count/countPerPage;
        }else {
            pages = count/countPerPage + 1;
        }
        jsonObject.put("first",1);
        jsonObject.put("last",count);
        jsonObject.put("groups",countPerPage);
        jsonObject.put("pages",pages);
        jsonObject.put("count",count);
        return jsonObject.toString();
    }


    @RequestMapping(value="/getOperatorListBySearch", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getOperatorListBySearch(OperatorVo operatorVo) {
        List<Operator> operators ;
        if(operatorVo.getId().equals("") && !operatorVo.getName().equals("")) {
            operators = operatorService.queryOperatorPageByName(operatorVo);
        }else if(!operatorVo.getId().equals("") && operatorVo.getName().equals("")) {
            operators = operatorService.queryOperatorPageById(operatorVo);
        }else {
            operators = operatorService.queryOperatorPageByIdAndName(operatorVo);
        }
        JSONArray jsonArray = JSONArray.fromObject(operators);
        return jsonArray.toString();
    }

    @RequestMapping(value="/uploadFile", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        JSONObject jsonObject = new JSONObject();
        String[] inputString = new String[3];
        String str;
        int count = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            while ((str=bufferedReader.readLine()) != null) {
                inputString[count] = str.trim();
                count++;
                if(count == 3) {
                    break;
                }
            }
        } catch (IOException e) {
            jsonObject.put("status","parseErr");
        }
//        mobileService.addMobiles(startTel,endTel,telLevel)
        if(count != 3) {
            jsonObject.put("status","parseErr");
        }else {
            // 验证
            String telLevel = inputString[0];
            String startTel = inputString[1];
            String endTel = inputString[2];
            if(!telLevel.equals("SIM")  && !telLevel.equals("UIM")) {
                jsonObject.put("status","parseErr");
            }else if(!mobileService.isPhoneNum(startTel)) {
                jsonObject.put("status","parseErr");
            }else if(!mobileService.isPhoneNum(endTel)) {
                jsonObject.put("status","parseErr");
            }else {
                if(mobileService.addMobiles(startTel,endTel,telLevel)) {
                    jsonObject.put("status","addRgt");
                }else {
                    jsonObject.put("status","addErr");
                }
            }
        }
        return jsonObject.toString();
    }

}
