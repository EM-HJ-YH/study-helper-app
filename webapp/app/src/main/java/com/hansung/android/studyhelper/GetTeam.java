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

import static com.hansung.android.studyhelper.TeamCalendarActivity.value2;

/**
 * Created by leeem on 2018-12-14.
 */

public class GetTeam extends GetRequest {
    static String team = null;
    public GetTeam(Activity activity) {
        super(activity);
    }
    static String myteamarray=null;
    static String teamarray;

    static String json = null;
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
            System.out.println("che" + team);
            JSONArray jsonArray = new JSONArray(team);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject SjsonObject = (JSONObject) jsonArray.get(i);
                if(SjsonObject.toString() != null) {
                    System.out.println("che" + SjsonObject);
                    System.out.println("eunmilee" + i);
                    if (SjsonObject.getString("members").contains("\"" + localstorage.ID + "\"")) {
                        //teamresult = new JSONObject(jsonObject.get("result").toString());
                        Team team = new Team(SjsonObject.getInt("groupIndex"),
                                SjsonObject.getString("groupMasterId"),
                                SjsonObject.getString("groupName"),
                                SjsonObject.getString("members"));
                        System.out.println(SjsonObject.getString("groupName"));

                            if(SjsonObject.getString("groupName").equals(value2)) {
                                TeamCalendarActivity.gindex = SjsonObject.getInt("groupIndex");
                            }

                        myteamarray = SjsonObject.getString("groupName");
                        teamarray = teamarray + myteamarray;
                        System.out.println("che" + myteamarray);
                        output.add(team);
                    }
                }

            }



        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return output;
    }
}
