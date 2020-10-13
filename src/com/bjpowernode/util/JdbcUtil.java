package com.bjpowernode.util;

import java.sql.*;

public class JdbcUtil {
    final String URL = "jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT";
    final String USERNAME="root";
    final String PASSWORD="china2002";
    Connection conn = null;
    PreparedStatement ps = null;
    // 将jar包中的driver是实现类加载到jvm中
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 封装连接通道创建细节
    public Connection getCon(){
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    // 封装交通工具创建细节
    public PreparedStatement createStatement(String sql){
        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    // ps和con销毁细节 insert， update， delete
    public void close(){
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
