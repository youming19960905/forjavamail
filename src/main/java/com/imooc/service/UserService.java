package com.imooc.service;

import com.imooc.domain.User;

import java.sql.SQLException;

public interface UserService {
    void reist(User user) throws Exception;

    User findByCode(String code) throws Exception;

    void update(User user) throws Exception;
}
