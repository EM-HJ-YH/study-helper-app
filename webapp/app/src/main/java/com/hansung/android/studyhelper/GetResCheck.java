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
 * Created by leeem on 2018-12-18.
 */

public class GetResCheck extends GetRequest {

    static String res = null;
    public GetResCheck(Activity activity) {
        super(activity);
    }
    @Override
    protected void onPreExecute() {

        String serverURLStr = ReservationActivity.defaultUrl.toString();
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
        ArrayList<rescheck> arrayList= getArrayListFromJSONString(jsonString);
        ArrayAdapter adapter = new ArrayAdapter(activity,
                android.R.layout.simple_list_item_1,
                arrayList.toArray());
        ListView resc = ResCheckActivity.resc;
        resc.setAdapter(adapter);
        resc.setDividerHeight(10);

    }


    protected ArrayList<rescheck> getArrayListFromJSONString(String jsonString) {
        ArrayList<rescheck> output = new ArrayList();

        try {
            System.out.println("Lee1");
            JSONObject json = new JSONObject(jsonString);
            res = json.get("result").toString();
            System.out.println("che" + res);
            JSONArray jsonArray = new JSONArray(res);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject SjsonObject = (JSONObject) jsonArray.get(i);
                if(SjsonObject.toString() != null) {
                    System.out.println("che" + SjsonObject);
                    System.out.println("eunmilee" + i);
                    if (SjsonObject.getString("cafeBookUserId").equals(localstorage.ID)) {
                        //teamresult = new JSONObject(jsonObject.get("result").toString());
                        rescheck rescheck = new rescheck(SjsonObject.getInt("cafeBookIndex"),
                                SjsonObject.getInt("cafeIndex"),
                                SjsonObject.getString("cafeBookUserId"),
                                SjsonObject.getString("cafeBookDate"),
                                SjsonObject.getString("cafeBookBeginTime"),
                                SjsonObject.getString("cafeBookEndTime"));


                        output.add(rescheck);
                    }
                }

            }



        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return output;
    }

}
