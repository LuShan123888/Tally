package com.example.service;

import com.example.bean.UserBean;
import com.example.dao.UserDao;

public class UserService {
    public static UserBean login(String username, String password) throws Exception {
        UserDao userDao = new UserDao();
        UserBean user = userDao.select(username);
        userDao.close();
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static int signUp(String username, String email, String password) throws Exception {
        UserDao userDao = new UserDao();
        if (userDao.select(username) == null) {
            UserBean user = userDao.add(username, email, password, "normal");
            userDao.close();
            return 1;
        } else {
            userDao.close();
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(UserService.login("Cian324", "123456"));
//        System.out.println(UserService.SignUp("23343fdgdfg43434","dsfrsdfsd","cas"));
    }
}
