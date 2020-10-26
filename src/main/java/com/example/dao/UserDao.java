package com.example.dao;

import com.example.bean.UserBean;
import com.example.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    Connection con = null;
    ResultSet res = null;
    PreparedStatement psmt = null;

    public UserDao() {
        try {
            con = DBConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserBean add(String username, String email, String password, String type) throws SQLException {
        psmt = con.prepareStatement("INSERT INTO User (Username, Password, Email,Type) VALUES (?,?,?,?)");
        psmt.setString(1, username);
        psmt.setString(2, password);
        psmt.setString(3, email);
        psmt.setString(4, type);
        if (!psmt.execute()) {
            psmt = con.prepareStatement("SELECT UserID FROM User WHERE Username=? AND Password=? AND Email=? AND Type=?");
            psmt.setString(1, username);
            psmt.setString(2, password);
            psmt.setString(3, email);
            psmt.setString(4, type);
            res = psmt.executeQuery();
            res.next();
//            System.out.println(res.getInt("UserID"));
            UserBean user = new UserBean(res.getInt("UserID"), username, password, email, type);
            return user;
        } else {
            return null;
        }
    }

    public int delete(UserBean user) {
        return 0;
    }

    public UserBean update(UserBean user) {
        return null;
    }

    public UserBean select(String username) throws SQLException {
        psmt = con.prepareStatement("SELECT UserID, Username, Password, Email, Type FROM User WHERE Username=?");
        psmt.setString(1, username);
        ResultSet res = psmt.executeQuery();
        if (res.next()) {
            return new UserBean(res.getInt("UserID"), res.getString("Username"), res.getString("Password"), res.getString("Email"), res.getString("Type"));
        } else {
            return null;
        }
    }

    public void close() throws Exception {
        DBConnector.DisConnect();
        con.close();
        con = null;
    }

    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao();

        userDao.select("dsfdsf");
//        UserBean user = new UserBean(0, "k234324dfi", "4322434", "23423@qq.com", "admin");
//        userDao.add("k234324dfi", "4322434", "23423@qq.com", "admin");

//        UserBean user = userDao.select("Ciddan");
//        System.out.println(user);

        userDao.close();
    }
}
