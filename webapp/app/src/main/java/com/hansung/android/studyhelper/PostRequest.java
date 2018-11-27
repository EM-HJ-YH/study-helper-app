package com.hansung.android.studyhelper;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import static com.hansung.android.studyhelper.MainActivity.flag;

public class PostRequest extends AsyncTask<JSONObject, Void, String> {
    Activity activity;
    URL url;
    static String token ="";


    public PostRequest(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected String doInBackground(JSONObject... postDataParams) {

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(10000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            String str = getPostDataString(postDataParams[0]);
            Log.e("params", "Post String = " + str);
            writer.write(str);

            writer.flush();
            writer.close();
            os.close();


            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {

                    sb.append(line);
                    break;
                }

                JSONObject s = null;
                s=new JSONObject(sb.toString());
                if(s.get("success").toString()=="true") {

                    MainActivity.login=3;

                    System.out.println("eunmi" + sb.toString());

                    JSONObject json = null;
                    JSONObject result = null;

                    try {
                        json = new JSONObject(sb.toString());
                        result = new JSONObject(json.get("result").toString());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("eunmi" + json.get("result"));
                    System.out.println("eunmi" + result.get("token"));
                    token = result.get("token").toString();
               }

                in.close();
                return sb.toString();

            } else {
                return new String("Server Error : " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(flag==1) {
            Toast.makeText(activity, result,
                    Toast.LENGTH_LONG).show();
            Toast.makeText(activity, "회원가입에 성공하였습니다.",
                    Toast.LENGTH_LONG).show();
        }
        else if(flag==2){
            Toast.makeText(activity, result,
                    Toast.LENGTH_LONG).show();
            Toast.makeText(activity, "로그인에 성공하였습니다.",
                    Toast.LENGTH_LONG).show();
        }
    }

    private String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while (itr.hasNext()) {

            String key = itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));


        }
        return result.toString();
    }
}