package com.example.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://db:3306/tally?serverTimezone=Asia/Shanghai&useSSL=false";
    private static final String username = "tally";
    private static final String password = "tally";
    private static Connection con;

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DBConnector() {
    }

    public static Connection getConnection() throws Exception {
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            return con;
        }
        return con;
    }

    public static void DisConnect() throws Exception {
        if (con != null) {
            con.close();
        }
        con = null;
    }

    public static void main(String[] args) {
        try {
            Connection con = DBConnector.getConnection();
            if (con != null) {
                System.out.println("successful");
            } else {
                System.out.println("failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
