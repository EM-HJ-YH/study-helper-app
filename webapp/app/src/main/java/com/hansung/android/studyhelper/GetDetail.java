package com.hansung.android.studyhelper;

import android.app.Activity;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by leeem on 2018-12-13.
 */

public class GetDetail extends PostRequest {
    public GetDetail(Activity activity) {
        super(activity);
    }


    @Override
    protected void onPreExecute() {

        String serverURLStr = WriteActivity.defaultUrl.toString();
        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
