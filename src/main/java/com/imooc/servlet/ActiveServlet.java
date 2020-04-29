package com.imooc.servlet;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //接收激活码
            String code = req.getParameter("code");
            //根据激活码查询用户
            UserService userService = new UserServiceImpl();
            User user = userService.findByCode(code);
            if(user != null){
                //查询到了这个激活码的对应用户，修改用户状态
                user.setState(1); //1表示用户激活
                user.setCode(null);
                userService.update(user);
                req.setAttribute("msg","您已激活成功，请去登录！");
            }else{
                req.setAttribute("msg","您的激活码有误，请重新激活！");
            }
            //页面跳转
            req.getRequestDispatcher("/msg.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
