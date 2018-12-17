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

import static com.hansung.android.studyhelper.GetTeam.team;
import static com.hansung.android.studyhelper.GetTeam.teamarray;

/**
 * Created by leeem on 2018-12-17.
 */

public class GetSchedules extends GetRequest {

    static String Schedules = null;
    public GetSchedules(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {

        String serverURLStr = TeamCalendarActivity.defaultUrl.toString();
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
        ArrayList<Schedules> arrayList= getArrayListFromJSONString(jsonString);
        ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView schedulelist = TeamCalendarActivity.schedulelist;
        schedulelist.setAdapter(adapter);
        schedulelist.setDividerHeight(10);



    }

    private ArrayList<Schedules> getArrayListFromJSONString(String jsonString) {

        ArrayList<Schedules> output = new ArrayList();

        try {
            System.out.println("Lee1");
            JSONObject json = new JSONObject(jsonString);
            Schedules = json.get("result").toString();
            JSONArray jsonArray = new JSONArray(Schedules);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                System.out.println("eunmilee"+teamarray);
                if(teamarray != null){
                if(teamarray.contains(jsonObject.getString("groupName"))) {
                   // teamresult = new JSONObject(jsonObject.get("result").toString());

                    Schedules Schedules = new Schedules(jsonObject.getInt("scheduleIndex"),
                            jsonObject.getString("scheduleYear"),
                            jsonObject.getString("scheduleMonth"),
                            jsonObject.getString("scheduleDay"),
                            jsonObject.getString("scheduleContent"),
                            jsonObject.getInt("groupIndex"),
                            jsonObject.getString("groupName"),
                            jsonObject.getString("posterId"));

                    output.add(Schedules);


                }


            }}
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return output;
    }
}
