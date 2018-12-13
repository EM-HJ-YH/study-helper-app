package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-03.
 */

public class Write {
    int boardIndex;
    String userId;
    String boardTitle;
    String boardDate;
    String boardContent;
    int memberCount;
    boolean isRecruiting;
    String members[];

    public Write(int boardIndex, String userId, String boardTitle, String boardDate, String boardContent, int memberCount, boolean isRecruiting, String[] members ){
        this.boardIndex=boardIndex;
        this.userId = userId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.memberCount = memberCount;
        this.isRecruiting = isRecruiting;
        this.members = members;
    }

    public String toString() {
        return String.format("boardIndex = %d \n userId = %s \n boardTitle = %s \n boardDate = %s \n memberCount = %d",boardIndex, userId,boardTitle,boardDate,memberCount);
    }
}
