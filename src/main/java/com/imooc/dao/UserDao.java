package com.imooc.dao;

import com.imooc.domain.User;

import java.sql.SQLException;

public interface UserDao {
    void regist(User user) throws SQLException;

    User findByCode(String code) throws SQLException;

    void update(User user)throws SQLException;
}
