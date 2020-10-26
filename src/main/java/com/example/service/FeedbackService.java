package com.example.service;

import com.example.bean.FeedbackBean;
import com.example.dao.FeedbackDao;

import java.util.List;

public class FeedbackService {
    public static int addFeedback(int userID, String nickname, String rates, String email, String suggestion) throws Exception {
        FeedbackDao feedbackDao = new FeedbackDao();
        int check = feedbackDao.add(userID, nickname, rates, email, suggestion);
        feedbackDao.close();
        return check;
    }

    public static List<FeedbackBean> getFeedback() throws Exception {
        FeedbackDao feedbackDao = new FeedbackDao();
        List<FeedbackBean> feedbackList = feedbackDao.select();
        feedbackDao.close();
        return feedbackList;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(addFeedback(100000001,"sdfsd","10","2312@qds.coma","nothing"));

        List<FeedbackBean> feedbackList = getFeedback();
        for (FeedbackBean feedback : feedbackList) {
            System.out.println(feedback.getEmail());
        }
    }
}
