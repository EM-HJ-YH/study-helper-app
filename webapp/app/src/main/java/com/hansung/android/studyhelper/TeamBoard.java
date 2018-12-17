package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-14.
 */

public class TeamBoard {

    int groupBoardIndex;
    int groupIndex;
    String groupName;
    String  groupBoardTitle;
    String groupBoardContent;
    String  groupBoardPosterId;
    String groupBoardDate;


    public TeamBoard( int groupBoardIndex,int groupIndex, String groupName, String  groupBoardTitle,
                      String groupBoardContent, String  groupBoardPosterId, String groupBoardDate){
        this.groupBoardIndex = groupBoardIndex;
        this.groupIndex=groupIndex;
        this.groupName = groupName;
        this.groupBoardTitle = groupBoardTitle;
        this.groupBoardContent = groupBoardContent;
        this.groupBoardPosterId = groupBoardPosterId;
        this.groupBoardDate =groupBoardDate;
    }

    public String toString() {
        return String.format("groupBoardIndex : %d \n groupIndex : %d \n groupName : %s \n groupBoardTitle : %s \n groupBoardContent : %s \n " +
                "groupBoardPosterId : %s \n groupBoardDate : %s",groupBoardIndex,groupIndex,groupName,groupBoardTitle,groupBoardContent,
                groupBoardPosterId , groupBoardDate  );
    }
}
