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

public class GetData extends GetRequest {
    public GetData(Activity activity) {
        super(activity);
    }

    static MypageActivity MypageActivity;

    @Override
    protected void onPreExecute() {

        String serverURLStr = RegisterActivity.defaultUrl.toString();
        try {
            url = new URL(serverURLStr+"/get"+"-"+"data");  // http://serverURLStr/get-data
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {
        if (jsonString == null)
            return;
        ArrayList<Regist> arrayList = getArrayListFromJSONString(jsonString);

        ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView txtList = activity.findViewById(R.id.txtList);
        txtList.setAdapter(adapter);
        txtList.setDividerHeight(10);
    }


    protected ArrayList<Regist> getArrayListFromJSONString(String jsonString) {
        ArrayList<Regist> output = new ArrayList();
        try {

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                Regist regist = new Regist(jsonObject.getString("userName"),
                        jsonObject.getString("userId"),
                        jsonObject.getString("userPw"),
                        jsonObject.getString("major"),
                        jsonObject.getString("admissionYear"));

                output.add(regist);
            }
        } catch (JSONException e) {
            Log.e(TAG, "Exception in processing JSONString.", e);
            e.printStackTrace();
        }
        return output;
    }
}