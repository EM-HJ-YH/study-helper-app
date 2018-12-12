package com.hansung.android.studyhelper;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by leeem on 2018-12-12.
 */

public class GetRecruiment extends GetRequest {

    static JSONObject teamresult = null;
    public GetRecruiment(Activity activity) {
        super(activity);
    }
    @Override
    protected void onPreExecute() {

        String serverURLStr = WriteActivity.defaultUrl.toString();
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
        ArrayList<Write> arrayList= getArrayListFromJSONString(jsonString);
        ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView TeamList = MainActivity.teamview;
        TeamList.setAdapter(adapter);
        TeamList.setDividerHeight(10);

    }


    protected ArrayList<Write> getArrayListFromJSONString(String jsonString) {
        ArrayList<Write> output = new ArrayList();
        try {
            System.out.println("Lee1");
            JSONArray jsonArray = new JSONArray(jsonString);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                System.out.println("eunmilee"+i);
                teamresult = new JSONObject(jsonObject.get("result").toString());
             //   Write write = new Write(jsonObject.get("result").toString().getString("userId"),
               //         jsonObject.getString("boardTitle"),
                 //       jsonObject.getString("boardDate"),
                   //     jsonObject.getInt("memberCount"));

                //output.add(write);

                teamresult.get("userId").toString();
                System.out.println(teamresult.get("team"+"userId").toString());
            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return output;
    }
}
