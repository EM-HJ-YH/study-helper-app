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
 * Created by leeem on 2018-12-15.
 */

public class GetScheduleTeam extends GetRequest {
    static String Steam = null;
    public GetScheduleTeam(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {

        String serverURLStr = MyTeamActivity.defaultUrl.toString();
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
        ArrayList<STeam> arrayList= getArrayListFromJSONString(jsonString);



    }

    private ArrayList<STeam> getArrayListFromJSONString(String jsonString) {

        ArrayList<STeam> output = new ArrayList();

        try {
            System.out.println("Lee1");
            JSONObject json = new JSONObject(jsonString);
            Steam = json.get("result").toString();
            JSONArray jsonArray = new JSONArray(Steam);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                System.out.println("eunmilee"+i);
                if(jsonObject.getString("members").contains("\""+localstorage.ID+"\"")) {
                    //teamresult = new JSONObject(jsonObject.get("result").toString());

                    STeam Steam = new STeam(jsonObject.getInt("groupIndex"),
                            jsonObject.getString("groupName"));

                    output.add(Steam);
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return output;
    }
    }

