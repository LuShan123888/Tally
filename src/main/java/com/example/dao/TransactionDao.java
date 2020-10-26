package com.example.dao;

import com.example.bean.TransactionBean;
import com.example.bean.UserBean;
import com.example.util.DBConnector;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//import java.com.example.util.Date;

public class TransactionDao {
    Connection con = null;
    ResultSet res = null;
    PreparedStatement psmt = null;

    public TransactionDao() {
        try {
            con = DBConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int add(int userID, String flow, String type, String amount, String remark, Date date, String note) throws SQLException {
        psmt = con.prepareStatement("INSERT INTO Transaction (UserID, Flow, Type,Amount,Remark,Date,Note) VALUES (?,?,?,?,?,?,?)");
        psmt.setInt(1, userID);
        psmt.setString(2, flow);
        psmt.setString(3, type);
        psmt.setString(4, amount);
        psmt.setString(5, remark);
        psmt.setDate(6, date);
        psmt.setString(7, note);
        if (!psmt.execute()) {
            psmt = con.prepareStatement("SELECT TransactionID FROM Transaction WHERE UserID=? AND Flow=? AND Type=? AND Amount=? AND Remark=? AND Date=? AND Note=?");
            psmt.setInt(1, userID);
            psmt.setString(2, flow);
            psmt.setString(3, type);
            psmt.setString(4, amount);
            psmt.setString(5, remark);
            psmt.setDate(6, (Date) date);
            psmt.setString(7, note);
            res = psmt.executeQuery();
            res.next();
//            System.out.println(res.getInt("UserID"));
//            TransactionBean transaction = new TransactionBean(res.getInt("TransactionID"), userID, flow, type, amount, remark, date, note);
            return 1;
        } else {
            return 0;
        }
    }

    public int delete(UserBean user) {
        return 0;
    }

    public TransactionBean update(UserBean user) {
        return null;
    }


    public List<TransactionBean> select(int userID) throws SQLException {
        psmt = con.prepareStatement("SELECT TransactionID, UserID, Flow, Type, Amount, Remark, Date, Note FROM Transaction WHERE UserID=?");
        psmt.setInt(1, userID);
        ResultSet res = psmt.executeQuery();
        List<TransactionBean> transactionList = new ArrayList<>();
        while (res.next()) {
            transactionList.add(new TransactionBean(res.getInt("TransactionID"), res.getInt("UserID"), res.getString("Flow"), res.getString("Type"), res.getString("Amount"), res.getString("Remark"), res.getDate("Date"), res.getString("Note")));
        }
        return transactionList;
    }

    public void close() throws Exception {
        DBConnector.DisConnect();
        con.close();
        con = null;
    }

    public static void main(String[] args) throws Exception {
        TransactionDao transactionDao = new TransactionDao();

        String string = "2016-10-24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(string);
        Date sqlDate = new Date(utilDate.getTime());
        transactionDao.add(100000001, "inflow", "餐饮", "100", "吃饭", sqlDate, "nothing");

//        List<TransactionBean> transactionList = transactionDao.select(100000001);
//        for (TransactionBean transaction:transactionList){
//            System.out.println(transaction.getAmount());
//        }
//
        transactionDao.close();
    }
}
