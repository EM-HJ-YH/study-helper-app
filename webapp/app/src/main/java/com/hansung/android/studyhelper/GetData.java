package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-11-20.
 */

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by kwanwoo on 2017. 10. 17..
 */

public class GetData extends PostRequest {
    public GetData(Activity activity) {
        super(activity);
    }

    static String name;
    static String id2;
    static String pw;
    static String major;
    static int admissionyear;



    @Override
    protected void onPreExecute() {

        String serverURLStr = RegisterActivity.defaultUrl.toString();
        try {
            url = new URL(serverURLStr);  // http://serverURLStr/get-data
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {
        if (jsonString == null)
            return;
        getArrayListFromJSONString(jsonString);


    }


    protected ArrayList<Regist> getArrayListFromJSONString(String jsonString) {
        ArrayList<Regist> output = new ArrayList();
        try {

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                if(jsonObject.getString("userName")=="a") {

                    name = jsonObject.getString("userName");
                    id2 = jsonObject.getString("userId");
                    pw = jsonObject.getString("userPw");
                    major = jsonObject.getString("major");
                    admissionyear = jsonObject.getInt("admissionYear");
                }

            }
        } catch (JSONException e) {
           // Log.e(TAG, "Exception in processing JSONString.", e);
            e.printStackTrace();
        }
        return output;
    }
}