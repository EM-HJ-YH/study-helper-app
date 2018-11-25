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

        String serverURLStr = SignInActivity.defaultUrl.toString();
        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}