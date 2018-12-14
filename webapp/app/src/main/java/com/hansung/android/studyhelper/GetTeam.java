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
 * Created by leeem on 2018-12-14.
 */

public class GetTeam extends GetRequest {
    static String team = null;
    public GetTeam(Activity activity) {
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
        ArrayList<Team> arrayList= getArrayListFromJSONString(jsonString);
        ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView MyTeamList = MyTeamActivity.myteamview;
        MyTeamList.setAdapter(adapter);
        MyTeamList.setDividerHeight(10);

    }


    protected ArrayList<Team> getArrayListFromJSONString(String jsonString) {
        ArrayList<Team> output = new ArrayList();

        try {
            System.out.println("Lee1");
            JSONObject json = new JSONObject(jsonString);
            team = json.get("result").toString();
            JSONArray jsonArray = new JSONArray(team);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                System.out.println("eunmilee"+i);
                    if(jsonObject.getString("members").contains("\""+localstorage.ID+"\"")) {
                        //teamresult = new JSONObject(jsonObject.get("result").toString());
                        Team team = new Team(jsonObject.getInt("groupIndex"),
                                jsonObject.getString("groupMasterId"),
                                jsonObject.getString("groupName"),
                                jsonObject.getString("members"));

                        output.add(team);
                    }

                // teamresult.get("userId").toString();
                //System.out.println(teamresult.get("team"+"userId").toString());
            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return output;
    }
}
