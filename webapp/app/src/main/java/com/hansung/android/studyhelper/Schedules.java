package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-17.
 */

public class Schedules {

    int scheduleIndex;
    String scheduleYear;
    String scheduleMonth;
    String scheduleDay;
    String scheduleContent;
    int groupIndex;
    String groupName;
    String  posterId;



    public Schedules( int scheduleIndex,String scheduleYear, String scheduleMonth, String scheduleDay,
                       String scheduleContent, int groupIndex, String groupName, String  posterId){
        this.scheduleIndex = scheduleIndex;
        this.scheduleYear=scheduleYear;
        this.scheduleMonth = scheduleMonth;
        this.scheduleDay = scheduleDay;
        this.scheduleContent = scheduleContent;
        this.groupIndex =groupIndex;
        this.groupName = groupName;
        this.posterId = posterId;
    }

    public String toString() {
        return String.format("scheduleIndex : %d \n scheduleYear : %s \n scheduleMonth : %s \n scheduleDay : %s \n " +
                        "scheduleContent : %s \n groupIndex : %d \n groupName : %s \n posterId : %s",scheduleIndex,scheduleYear,scheduleMonth,scheduleDay,
                scheduleContent , groupIndex, groupName, posterId  );
    }
}
