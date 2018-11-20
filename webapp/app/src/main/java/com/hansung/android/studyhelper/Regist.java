package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-11-20.
 */

public class Regist {

    String name;
    String id;
    String pw;
    String major;
    String grade;

    public Regist(String name, String id, String pw, String major, String grade){
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.major = major;
        this.grade = grade;
    }

    public String toString() {
        return String.format("Name = %s \n ID = %s \n Pw = %s \n Major = %s \n Grade = %s",name, id,pw,major,grade);
    }
}
