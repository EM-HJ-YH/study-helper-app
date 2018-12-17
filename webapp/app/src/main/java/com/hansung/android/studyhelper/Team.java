package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-14.
 */

public class Team {

    int groupIndex;
    String groupMasterId;
    String groupName;
    String members;

    public Team(int groupIndex, String groupMasterId,  String groupName, String members ){
        this.groupIndex=groupIndex;
        this.groupMasterId = groupMasterId;
        this.groupName = groupName;
        this.members = members;
    }

    public String toString() {
        return String.format("groupIndex : %d \n groupMasterId : %s \n groupName : %s \n members : %s",groupIndex, groupMasterId,groupName,members);
    }
}
