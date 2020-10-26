package com.example.service;

import com.example.bean.TransactionBean;
import com.example.dao.TransactionDao;

import java.text.SimpleDateFormat;
import java.util.List;

public class TransactionService {
    public static int recordTransaction(int userID, String flow, String type, String amount, String remark, String date, String note) throws Exception {
        TransactionDao transactionDao = new TransactionDao();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(utilDate);
        int check = transactionDao.add(userID, flow, type, amount, remark, sqlDate, note);
        transactionDao.close();
        return check;
    }

    public static List<TransactionBean> getTransactionsByUserID(int userID) throws Exception {
        TransactionDao transactionDao = new TransactionDao();
        List<TransactionBean> transactionList = transactionDao.select(userID);
        transactionDao.close();
        return transactionList;
    }

    public static void main(String[] args) throws Exception {

//        List<TransactionBean> transactionList = getTransactionsByUserID(100000001);
//        for (TransactionBean transaction:transactionList){
//            System.out.println(transaction.getAmount());
//        }

        System.out.println(recordTransaction(100000001, "inflow", "餐饮", "100", "吃饭", "2020-1-1", "nothing"));

    }
}
