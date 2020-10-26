package com.example.bean;

public class FeedbackBean {

    private int FeedbackID;
    private int UserID;
    private String Nickname;
    private String Rates;
    private String Email;
    private String Suggestion;

    public FeedbackBean() {
    }

    public FeedbackBean(int FeedbackID, int UserID, String Nickname, String Rates, String Email, String Suggestion) {
        this.FeedbackID = FeedbackID;
        this.UserID = UserID;
        this.Nickname = Nickname;
        this.Rates = Rates;
        this.Email = Email;
        this.Suggestion = Suggestion;
    }

    public int getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(int FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getRates() {
        return Rates;
    }

    public void setRates(String Rates) {
        this.Rates = Rates;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSuggestion() {
        return Suggestion;
    }

    public void setSuggestion(String Suggestion) {
        this.Suggestion = Suggestion;
    }

}
