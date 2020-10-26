package com.example.bean;

public class UserBean {

    private int UserID;
    private String Username;
    private String Password;
    private String Email;
    private String Type;

    public UserBean() {

    }

    public UserBean(int UserID, String Username, String Password, String Email, String Type) {
        this.UserID = UserID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Type = Type;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
}