package com.example.kuranikerimm;

public class User {
    private Veriler userName;
    private String filtre;
    private boolean userGender;
    private int sira;


    public User(Veriler userName, String filtre , boolean userGender) {
        this.userName = userName;
        this.filtre = filtre;
        this.userGender = userGender;
    }

    public Veriler getUserName() {
        return userName;
    }

    public void setUserName(Veriler userName) {
        this.userName = userName;
    }

    public String getFiltre() {
        return filtre;
    }

    public void setFiltre() {
        this.filtre = filtre;
    }

    public Boolean isUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

}
