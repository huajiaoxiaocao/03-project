package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    JdbcUtil ju = new JdbcUtil();
    // 用户注册
    public int add(Users user){
        int result = 0;
        String sql = "insert into users(userName, password, sex, email)" +
                " values(?, ?, ?, ?)";
        PreparedStatement ps = ju.createStatement(sql);
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ju.close();
        }
        return result;
    }
    //查询所有用户信息
    public List findAll(){
        String sql = "select * from users";
        PreparedStatement ps = ju.createStatement(sql);
        ResultSet rs = null;
        List usersList = new ArrayList();
        try {
            rs= ps.executeQuery();
            while(rs.next()){
                Integer userid = rs.getInt("userId");
                String username = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userid, username, password, sex, email);
                usersList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ju.close(rs);
        }

        return usersList;
    }
    // 删除用户信息
    public int delete(String userId){
        String sql="delete from users where userId=?";
        int result=0;
        PreparedStatement ps = ju.createStatement(sql);
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ju.close();
        }
        return result;
    }
    // 验证用户信息
    public int login(String userName, String password){
        String sql = "select count(*) from users where userName=? and password=?";
        ResultSet rs = null;
        int result = 0;
        PreparedStatement ps = null;
        ps = ju.createStatement(sql);
        try {
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ju.close(rs);
        }
        return result;
    }
}
