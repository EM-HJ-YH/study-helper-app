package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-11-20.
 */

public class Regist {

    String userName;
    String userId;
    String userPw;
    String major;
    int admissionYear;

    public Regist(String userName, String userId, String userPw, String major, int admissionYear){
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.major = major;
        this.admissionYear = admissionYear;
    }

    public String toString() {
        return String.format("userName : %s \n userId : %s \n userPw : %s \n major : %s \n admissionYear : %d",userName, userId,userPw,major,admissionYear);
    }
}