package com.cmbs.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author: zwc
 * @date: 2018/9/6 19:26
 * @description:
 */
@Controller
public class ExitController{

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        Enumeration em = session.getAttributeNames();
        while(em.hasMoreElements()){
            session.removeAttribute(em.nextElement().toString());
        }
        return "redirect:/login/login.html";
    }
}
