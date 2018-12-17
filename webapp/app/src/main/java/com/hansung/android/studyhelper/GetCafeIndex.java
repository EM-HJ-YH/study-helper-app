package com.hansung.android.studyhelper;

import android.app.Activity;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.hansung.android.studyhelper.StudyCafeActivity.googleMap2;
import static com.hansung.android.studyhelper.StudyCafeActivity.markername;
import static com.hansung.android.studyhelper.StudyCafeActivity.sc1;

/**
 * Created by leeem on 2018-12-18.
 */

public class GetCafeIndex extends GetRequest {
    static String cafeinfo2 =null;
    static String Cafe2 = null;
    static int cafein;
    public GetCafeIndex(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {

        String serverURLStr = StudyCafeActivity.defaultUrl.toString();
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
        ArrayList<Cafe> arrayList= getArrayListFromJSONString(jsonString);



    }

    private ArrayList<Cafe> getArrayListFromJSONString(String jsonString) {

        ArrayList<Cafe> output = new ArrayList();

        try {
            System.out.println("Lee1");
            JSONObject json = new JSONObject(jsonString);
            Cafe2 = json.get("result").toString();
            JSONArray jsonArray = new JSONArray(Cafe2);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {
                //len = jsonArray.length();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                cafeinfo2 = jsonObject.toString();
                System.out.println("eunmilee"+jsonObject);

                Cafe Cafe = new Cafe(jsonObject.getInt("cafeIndex"),
                        jsonObject.getDouble("latitude"),
                        jsonObject.getDouble("longitude"),
                        jsonObject.getString("cafeName"),
                        jsonObject.getString("cafePhone"));

                if(markername.equals(jsonObject.getString("cafeName"))){
                    cafein=jsonObject.getInt("cafeIndex");
                }

                //cafenames = cafenames + jsonObject.getString("cafeName");



                output.add(Cafe);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return output;
    }
}
