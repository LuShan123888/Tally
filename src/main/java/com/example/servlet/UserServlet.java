package com.example.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.UserBean;
import com.example.service.UserService;
import com.example.util.Mail;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/UserServlet"}, name = "UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject message = new JSONObject();
        HttpSession session = request.getSession(true);
        if (request.getParameter("action").equals("signOut")) {
            session.setAttribute("user", null);
            message.put("message", "signOutSuccessfully");
//            String jsonStr = "{\"message\":\"SignOutSuccessfully\"}";
            out.print(message.toJSONString());
//            out.write("SignOutSuccessfully");
        }
        if (request.getParameter("action").equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try {
                UserBean user = UserService.login(username, password);
                if (user != null) {
                    session.setAttribute("user", user);
//                    String jsonStr = "{\"message\":\"LoginSuccessfully\"}";
//                    out.print(jsonStr);
                    message.put("message", "loginSuccessfully");
                    message.put("userID", user.getUserID());
                    message.put("password", user.getPassword());
                    message.put("email", user.getEmail());
                    message.put("type", user.getType());
                    message.put("username", user.getUsername());
                    out.print(message.toJSONString());
                } else {
                    message.put("message", "loginFailed");
//                    String jsonStr = "{\"message\":\"LoginFailed\"}";
                    out.print(message.toJSONString());
//                    out.write("LoginFailed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (request.getParameter("action").equals("signup")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Mail mail = new Mail(username, password,email);
            mail.start();
            try {
                int check = UserService.signUp(username, email, password);
                if (check == 1) {
                    message.put("message", "signUpSuccessfully");
//                    String jsonStr = "{\"message\":\"SignUpSuccessfully\"}";
                    out.print(message.toJSONString());
//                    out.write("SignUpSuccessfully");
                } else {
//                    String jsonStr = "{\"message\":\"SignUpFailed\"}";
                    message.put("message", "signUpFailed");
                    out.print(message.toJSONString());
//                    out.write("SignUpFailed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
