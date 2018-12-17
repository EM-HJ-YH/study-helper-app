package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-18.
 */

public class rescheck {


    int cafeBookIndex;
    int cafeIndex;
    String cafeBookUserId;
    String cafeBookDate;
    String cafeBookBeginTime;
    String cafeBookEndTime;

    public rescheck(int cafeBookIndex, int cafeIndex, String cafeBookUserId, String cafeBookDate, String cafeBookBeginTime ,String cafeBookEndTime ){
        this.cafeBookIndex=cafeBookIndex;
        this.cafeIndex = cafeIndex;
        this.cafeBookUserId = cafeBookUserId;
        this.cafeBookDate = cafeBookDate;
        this.cafeBookBeginTime = cafeBookBeginTime;
        this.cafeBookEndTime = cafeBookEndTime;
    }

    public String toString() {
        return String.format("cafeBookIndex : %d \n cafeIndex : %d \n cafeBookUserId : %s \n cafeBookDate : %s \n cafeBookBeginTime : %s \n cafeBookEndTime : %s",
                cafeBookIndex,cafeIndex, cafeBookUserId,cafeBookDate,cafeBookBeginTime, cafeBookEndTime);
    }
}
