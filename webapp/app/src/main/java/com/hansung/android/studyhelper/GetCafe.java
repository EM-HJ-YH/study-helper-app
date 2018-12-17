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
import static com.hansung.android.studyhelper.StudyCafeActivity.sc1;

/**
 * Created by leeem on 2018-12-17.
 */

public class GetCafe extends GetRequest {
    static String Cafe = null;
    static int len =0;
    static String cafeinfo =null;
    static String cafenames = null;





    public GetCafe(Activity activity) {
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
            Cafe = json.get("result").toString();
            JSONArray jsonArray = new JSONArray(Cafe);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {
                    len = jsonArray.length();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                cafeinfo = jsonObject.toString();
                System.out.println("eunmilee"+jsonObject);

                    Cafe Cafe = new Cafe(jsonObject.getInt("cafeIndex"),
                            jsonObject.getDouble("latitude"),
                            jsonObject.getDouble("longitude"),
                            jsonObject.getString("cafeName"),
                            jsonObject.getString("cafePhone"));

                    cafenames = cafenames + jsonObject.getString("cafeName");

                    sc1 = new LatLng(jsonObject.getDouble("latitude"), jsonObject.getDouble("longitude"));
                googleMap2.addMarker(
                        new MarkerOptions().
                                position(sc1).
                                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).
                                title(jsonObject.getString("cafeName")));


                    output.add(Cafe);

                }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return output;
    }
}
