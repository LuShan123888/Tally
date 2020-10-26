package com.example.bean;

import java.sql.Date;

public class TransactionBean {
    private int TransactionID;
    private int UserID;
    private String Flow;
    private String Type;
    private String Amount;
    private String Remark;
    private java.sql.Date Date;
    private String Note;

    public TransactionBean() {

    }

    public TransactionBean(int TransactionID, int UserID, String Flow, String Type, String Amount, String Remark, Date Date, String Note) {
        this.TransactionID = TransactionID;
        this.UserID = UserID;
        this.Flow = Flow;
        this.Type = Type;
        this.Amount = Amount;
        this.Remark = Remark;
        this.Date = Date;
        this.Note = Note;
    }

    public int getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(int TransactionID) {
        this.TransactionID = TransactionID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFlow() {
        return Flow;
    }

    public void setFlow(String Flow) {
        this.Flow = Flow;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

}
