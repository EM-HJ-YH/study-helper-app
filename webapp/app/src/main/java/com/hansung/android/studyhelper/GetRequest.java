package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-11-20.
 */

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import static com.hansung.android.studyhelper.localstorage.token;

abstract public class GetRequest extends AsyncTask<String, Void, String> {
    final static String TAG = "AndroidNodeJS";
    Activity activity;
    URL url;

    public GetRequest(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected String doInBackground(String... strings) {
        StringBuffer output = new StringBuffer();

        try {
            if (url == null) {
                Log.e(TAG, "Error: URL is null ");
                return null;
            }
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn == null) {
                Log.e(TAG, "HttpsURLConnection Error");
                return null;
            }
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(false);
            if(token!=null)
            {   System.out.println("eunmi"  +token);
                conn.setRequestProperty("x-access-token", token);
                System.out.println("eunmi"  +token);

            }


            int resCode = conn.getResponseCode();

            if (resCode != HttpsURLConnection.HTTP_OK) {
                Log.e(TAG, "HttpsURLConnection ResponseCode: " + resCode);
                conn.disconnect();
                return null;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                output.append(line + "\n");
            }

            reader.close();
            conn.disconnect();

        } catch (IOException ex) {
            Log.e(TAG, "Exception in processing response.", ex);
            ex.printStackTrace();
        }

        return output.toString();
    }

}