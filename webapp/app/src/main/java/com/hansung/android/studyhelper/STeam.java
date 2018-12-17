package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-15.
 */

public class STeam {


    int groupIndex;
    String groupMasterId;
    String groupName;
    String members;

    public STeam(int groupIndex, String groupName ){
        this.groupIndex=groupIndex;
        //this.groupMasterId = groupMasterId;
        this.groupName = groupName;
        //this.members = members;
    }

    public String toString() {
        return String.format("groupIndex : %d \n groupName : %s ",groupIndex,groupName);
    }
}
