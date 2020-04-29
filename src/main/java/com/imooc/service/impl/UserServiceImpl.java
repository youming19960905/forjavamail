package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;


public class UserServiceImpl implements UserService {
    @Override
    public void reist(User user) throws Exception {
        //调用dao
        UserDao userDao = new UserDaoImpl();
        userDao.regist(user);

        //发送一封激活邮件
        MailUtils.sendMail(user.getEmail(),user.getCode());
        System.out.println("已执行sendMail()方法！！！");
    }

    //根据激活码查询，返回User对象
    @Override
    public User findByCode(String code) throws Exception{
        UserDao userDao = new UserDaoImpl();
        return userDao.findByCode(code);
    }

    //更新用户
    @Override
    public void update(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }
}
