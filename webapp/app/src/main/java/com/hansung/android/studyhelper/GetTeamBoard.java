package com.hansung.android.studyhelper;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.hansung.android.studyhelper.MyTeamActivity.c2;

/**
 * Created by leeem on 2018-12-14.
 */

public class GetTeamBoard extends GetRequest{
    //final static String defaultUrl = "http://54.180.105.16:80/groupBoard";
    static String teamboard = null;
    public GetTeamBoard(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {

        String serverURLStr = TeamBoardActivity.defaultUrl.toString();

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
        ArrayList<TeamBoard> arrayList= getArrayListFromJSONString(jsonString);
        ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView teamboardview = TeamBoardActivity.teamboardview;
        teamboardview.setAdapter(adapter);
        teamboardview.setDividerHeight(10);

    }


    protected ArrayList<TeamBoard> getArrayListFromJSONString(String jsonString) {
        ArrayList<TeamBoard> output = new ArrayList();

        try {
            System.out.println("Lee1");
            JSONObject json = new JSONObject(jsonString);
            teamboard = json.get("result").toString();
            JSONArray jsonArray = new JSONArray(teamboard);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                System.out.println("eunmilee"+i);
                if(jsonObject.getString("groupName").equals(c2)) {
                    //teamresult = new JSONObject(jsonObject.get("result").toString());
                    TeamBoard teamBoard = new TeamBoard(jsonObject.getInt("groupBoardIndex"),
                            jsonObject.getInt("groupIndex"),
                            jsonObject.getString("groupName"),
                            jsonObject.getString("groupBoardTitle"),
                            jsonObject.getString("groupBoardContent"),
                            jsonObject.getString("groupBoardPosterId"),
                            jsonObject.getString("groupBoardDate"));

                    output.add(teamBoard);
                }


            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return output;
    }
}
