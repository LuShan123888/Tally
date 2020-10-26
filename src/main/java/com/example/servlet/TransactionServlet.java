package com.example.servlet;

import com.example.bean.TransactionBean;
import com.example.bean.UserBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.service.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/TransactionServlet"}, name = "TransactionServlet")
public class TransactionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        JSONObject message = new JSONObject();
        UserBean user = (UserBean) session.getAttribute("user");
        if (user != null&&user.getUserID()!=0) {
            if (request.getParameter("action").equals("getTransaction")) {
                List<TransactionBean> transactionList = null;
                try {
                    transactionList = TransactionService.getTransactionsByUserID(user.getUserID());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (transactionList != null) {
                    message.put("message", "getTransactionSuccessfully");
                    JSONArray jsonArrays = (JSONArray) JSON.toJSON(transactionList);
                    jsonArrays.add(message);
                    out.print(jsonArrays.toJSONString());
                } else {
                    message.put("message", "getTransactionFailed");
                    JSONArray jsonArrays = new JSONArray();
                    jsonArrays.add(message);
                    out.print(jsonArrays.toJSONString());
                }
            }
            if (request.getParameter("action").equals("addTransaction")) {
                String flow = request.getParameter("flow");
                String type = request.getParameter("type");
                String amount = request.getParameter("amount");
                String remark = null;
                if (request.getParameter("remark") != null) {
                    remark = request.getParameter("remark");
                }
                String date = request.getParameter("date");
                String note = null;
                if (request.getParameter("note") != null) {
                    note = request.getParameter("note");
                }
                int check = 0;
                try {
                    check = TransactionService.recordTransaction(user.getUserID(), flow, type, amount, remark, date, note);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (check == 1) {
                    message.put("message", "addTransactionSuccessfully");
                    out.print(message.toJSONString());
                } else {
                    message.put("message", "addTransactionFailed");
                    out.print(message.toJSONString());
                }
            }
        } else {
            message.put("message", "userCheckFailed");
            out.print(message.toJSONString());
        }
    }
}
