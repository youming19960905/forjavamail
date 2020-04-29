package com.imooc.dao.impl;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;
import com.imooc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void regist(User user) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into users values(?,?,?,?,?,?,?)";
        Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(),user.getState(),user.getCode()};
        queryRunner.update(sql,params);
    }

    //根据激活码查询用户的SQL方法
    @Override
    public User findByCode(String code) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from users where code = ?";
        User user = queryRunner.query(sql,new BeanHandler<User>(User.class) , code);
        return user;
    }

    //更新用户
    @Override
    public void update(User user) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update users set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
        Object[] params = {user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(),user.getState(),user.getCode(),user.getUid()};
        queryRunner.update(sql,params);

    }
}
