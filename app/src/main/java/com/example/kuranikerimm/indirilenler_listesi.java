package com.example.kuranikerimm;

import java.io.File;

public class indirilenler_listesi {
    //private boolean userGender;
    private File fileName;



    public indirilenler_listesi(File fileName /*boolean userGender*/) {
        //this.userGender = userGender;
        this.fileName = fileName;
    }

    public File getFileName() {
       return  fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

   /* public Boolean isUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }*/


}
