package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-11-23.
 */

public class SignIn {

    String userId;
    String userPw;

    public SignIn(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
         }

    public String toString() {
        return String.format("userId = %s \n userPw = %s ",userId,userPw);
    }
}
