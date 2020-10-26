package com.example.servlet;

import com.example.bean.FeedbackBean;
import com.example.bean.UserBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.service.FeedbackService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/FeedbackServlet"}, name = "FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        JSONObject message = new JSONObject();
        UserBean user = (UserBean) session.getAttribute("user");
        if (user != null&&user.getUserID()!=0) {
            if (request.getParameter("action").equals("getFeedback")) {
                List<FeedbackBean> feedbackList = null;
                try {
                    feedbackList = FeedbackService.getFeedback();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (feedbackList != null) {
                    message.put("message", "getFeedbackSuccessfully");
                    JSONArray jsonArrays = (JSONArray) JSON.toJSON(feedbackList);
                    jsonArrays.add(message);
                    out.print(jsonArrays.toJSONString());
                } else {
                    message.put("message", "getFeedbackFailed");
                    JSONArray jsonArrays = new JSONArray();
                    jsonArrays.add(message);
                    out.print(jsonArrays.toJSONString());
                }
            }
            if (request.getParameter("action").equals("addFeedback")) {
                String rates = request.getParameter("rates");
                String nickname = null;
                if (request.getParameter("nickname") != null) {
                    nickname = request.getParameter("nickname");
                }
                String email = null;
                if (request.getParameter("email") != null) {
                    email = request.getParameter("email");
                }
                String suggestion = null;
                if (request.getParameter("suggestion") != null) {
                    suggestion = request.getParameter("suggestion");
                }
                int check = 0;
                try {
                    check = FeedbackService.addFeedback(user.getUserID(), nickname, rates, email, suggestion);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (check == 1) {
                    message.put("message", "addFeedbackSuccessfully");
                    out.print(message.toJSONString());
                } else {
                    message.put("message", "addFeedbackFailed");
                    out.print(message.toJSONString());
                }
            }
        } else {
            message.put("message", "userCheckFailed");
            out.print(message.toJSONString());
        }
    }
}


