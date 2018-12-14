package com.hansung.android.studyhelper;

import android.app.Activity;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by leeem on 2018-12-14.
 */

public class EditData extends PutRequest {
    public EditData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        String serverURLStr="";

        if(MainActivity.flag==10){
            serverURLStr = "http://54.180.105.16:80/boards/addMember/" + MainActivity.a+ "/"+ localstorage.ID;
        }



        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
