package com.imooc.servlet;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
import com.imooc.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //处理乱码
            //接收数据
            req.setCharacterEncoding("utf-8");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String nickname = req.getParameter("nickname");
            String email = req.getParameter("email");

            //封装数据
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setEmail(email);
            user.setState(0);

            String code = UUIDUtils.getUUID() + UUIDUtils.getUUID(); //64个
            user.setCode(code);

            //调用业务层
            UserService userService = new UserServiceImpl();
            userService.reist(user);

            //页面跳转
            req.setAttribute("msg","您已注册成功！请去邮箱激活吧！");
            req.getRequestDispatcher("/msg.jsp").forward(req,resp);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
