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

import static java.lang.System.out;

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
    static String admissionyear;



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
        ArrayList<Regist> arrayList= getArrayListFromJSONString(jsonString);


    }


    protected ArrayList<Regist> getArrayListFromJSONString(String jsonString) {
        ArrayList<Regist> output = new ArrayList();
        try {

            JSONArray jsonArray = new JSONArray(jsonString);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                System.out.println("Lee2");
                if(jsonObject.getString("userId")==localstorage.ID) {

                    name = jsonObject.getString("userName");
                    System.out.println("Lee"+name);
                    id2 = jsonObject.getString("userId");
                    System.out.println("Lee"+id2);
                    pw = jsonObject.getString("userPw");
                    System.out.println("Lee"+pw);
                    major = jsonObject.getString("major");
                    System.out.println("Lee"+major);
                    admissionyear = jsonObject.getString("admissionYear");
                    System.out.println("Lee"+admissionyear);
                }


            }
        } catch (JSONException e) {
           // Log.e(TAG, "Exception in processing JSONString.", e);
            e.printStackTrace();
        }
        return output;
    }
}