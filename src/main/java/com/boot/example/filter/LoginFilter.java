package com.boot.example.filter;

import com.boot.example.pojo.User;
import com.boot.example.utils.Commons;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: kaison
 * Date: 2018/4/1
 * Time: 11:10
 * Description:
 */
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        String basePath = servletRequest.getScheme() + "://" + servletRequest.getServerName() + ":" + servletRequest.getServerPort() + servletRequest.getContextPath() + "/";
        // 从session里获取登录信息
        User customerUser = (User) session.getAttribute("login_user");
        //静态文件放行
        if (path.indexOf(".css") > -1 || path.indexOf(".js") > -1 || path.indexOf(".png") > -1 || path.indexOf(".jpg") > -1 || path.indexOf(".gif") > -1) {
            filterChain.doFilter(request, response);
            return;
        }
        // 过滤页面
        if (path.indexOf("/login.html") > -1 || path.indexOf("/doLogin") > -1) {
            filterChain.doFilter(request, response);
            return;
        }
        if(customerUser == null){
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> hash_rtn = new HashMap<>();
            hash_rtn.put(Commons.JSON_RES, Commons.JSON_NO);
            hash_rtn.put(Commons.JSON_ERROR, 101);
            //servletResponse.getWriter().write(mapper.writeValueAsString(hash_rtn));
            servletResponse.sendRedirect(basePath + "/login.html");
        }else {
            // 已经登陆,继续此次请求
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
