package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-03.
 */

public class Write {
    int boardIndex;
    String userId;
    String boardTitle;
    String boardDate;
    int memberCount;
    boolean isRecruiting;
    String members[];

    public Write( String userId, String boardTitle, String boardDate, int memberCount){
        this.userId = userId;
        this.boardTitle = boardTitle;
        this.boardDate = boardDate;
        this.memberCount = memberCount;
    }

    public String toString() {
        return String.format(" userId = %s \n boardTitle = %s \n boardDate = %s \n memberCount = %d", userId,boardTitle,boardDate,memberCount);
    }
}
