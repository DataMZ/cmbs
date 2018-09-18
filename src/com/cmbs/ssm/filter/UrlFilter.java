package com.cmbs.ssm.filter;

import com.cmbs.ssm.pojo.Operator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: zwc
 * @date: 2018/9/4 11:10
 * @description:
 */
@WebFilter("/*")
public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        Object accountClass = request.getSession().getAttribute("accountClass");
        if(!uri.contains(".html") && !uri.contains(".jsp") && !uri.contains(".action") || uri.contains("loginCheck.action")) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else if(accountClass == null && !uri.contains("login.html")) {
            response.sendRedirect(request.getContextPath()+"/login/login.html");
        }else if(accountClass != null && !uri.contains("login.html") && (uri.contains("/user/")
                || uri.contains("/operator/") || uri.contains("/admin/")) ) {
            if(accountClass.equals("Operator")) {
                Operator account = (Operator) request.getSession().getAttribute("account");
                if(account.getIsAdmin().equals("Y") && !uri.contains("/admin/")) {
                    if( uri.contains("/operator/") && !uri.contains("/operator/index.jsp")){
                        filterChain.doFilter(servletRequest,servletResponse);
                    }else {
                        response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
                    }
                }else if(account.getIsAdmin().equals("N") && !uri.contains("/operator/") ) {
                    response.sendRedirect(request.getContextPath()+"/operator/index.jsp");
                }else {
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }else if(!uri.contains("/user/")) {
                response.sendRedirect(request.getContextPath()+"/user/index.jsp");
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
