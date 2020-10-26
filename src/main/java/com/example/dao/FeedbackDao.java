package com.example.dao;

import com.example.bean.FeedbackBean;
import com.example.bean.TransactionBean;
import com.example.bean.UserBean;
import com.example.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {
    Connection con = null;
    ResultSet res = null;
    PreparedStatement psmt = null;

    public FeedbackDao() {
        try {
            con = DBConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int add(int userID, String nickname, String rates, String email, String suggestion) throws SQLException {
        psmt = con.prepareStatement("INSERT INTO Feedback(UserID,Nickname,Rates,Email,Suggestion) VALUES (?,?,?,?,?)");
        psmt.setInt(1, userID);
        psmt.setString(2, nickname);
        psmt.setString(3, rates);
        psmt.setString(4, email);
        psmt.setString(5, suggestion);
        if (!psmt.execute()) {
            psmt = con.prepareStatement("SELECT FeedbackID FROM Feedback WHERE UserID=?  AND Nickname=? AND Rates=? AND Email=? AND Suggestion=?");
            psmt.setInt(1, userID);
            psmt.setString(2, nickname);
            psmt.setString(3, rates);
            psmt.setString(4, email);
            psmt.setString(5, suggestion);
            res = psmt.executeQuery();
            res.next();
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


    public List<FeedbackBean> select() throws SQLException {
        psmt = con.prepareStatement("SELECT FeedbackID, UserID, Nickname, Rates,Email, Suggestion FROM Feedback");
        ResultSet res = psmt.executeQuery();
        List<FeedbackBean> FeedbackList = new ArrayList<>();
        while (res.next()) {
            FeedbackList.add(new FeedbackBean(res.getInt("FeedbackID"), res.getInt("UserID"), res.getString("Nickname"), res.getString("Rates"), res.getString("Email"), res.getString("Suggestion")));
        }
        return FeedbackList;
    }

    public void close() throws Exception {
        DBConnector.DisConnect();
        con.close();
        con = null;
    }

    public static void main(String[] args) throws Exception {
        FeedbackDao feedbackDao = new FeedbackDao();
//        System.out.println(feedbackDao.add(100000001, "CIanf", "10", "dsfddsf@qq.com", "nothing"));

        List<FeedbackBean> feedbackBeanList = new ArrayList<>();
        feedbackBeanList = feedbackDao.select();
        for (FeedbackBean feedback : feedbackBeanList) {
            System.out.println(feedback.getFeedbackID());
        }

        feedbackDao.close();
    }
}
