package com.hansung.android.studyhelper;

import android.app.Activity;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by leeem on 2018-11-19.
 */

public class InsertData extends PostRequest {
    public InsertData(Activity activity) {
        super(activity);
    }


    @Override
    protected void onPreExecute() {
        String serverURLStr="";

        if(MainActivity.flag == 1){
            serverURLStr = RegisterActivity.defaultUrl.toString();
        }
        else if(MainActivity.flag==2){
            serverURLStr = SignInActivity.defaultUrl.toString();
        }

        else if(MainActivity.flag==4){
            serverURLStr = WriteActivity.defaultUrl.toString();
        }
        else if(MainActivity.flag==10){
            serverURLStr = "http://54.180.105.16:80/boards/addMember/" + MainActivity.a+ "/"+ localstorage.ID;
        }



        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}