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
import static com.hansung.android.studyhelper.localstorage.ID;
import static com.hansung.android.studyhelper.localstorage.Name;
import static com.hansung.android.studyhelper.localstorage.Major;
import static com.hansung.android.studyhelper.localstorage.AdmissionYear;
import static com.hansung.android.studyhelper.localstorage.token;

public class PostRequest extends AsyncTask<JSONObject, Void, String> {
    Activity activity;
    URL url;
    static JSONObject result = null;


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
            if(token!=null)
            {   System.out.println("eunmi"  +token);
                conn.setRequestProperty("x-access-token", token);
                System.out.println("eunmi"  +token);
               // localstorage.PW = postDataParams[0].get("userPw").toString();

            }
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

                if(MainActivity.flag==2) {

                    JSONObject s = null;
                    s = new JSONObject(sb.toString());
                    if (s.get("success").toString() == "true") {

                        MainActivity.login = 3;
                        flag=5;
                        System.out.println("eunmi" + flag);
                        System.out.println("eunmi" + sb.toString());

                        JSONObject json = null;


                        //
                        try {
                            json = new JSONObject(sb.toString());
                            result = new JSONObject(json.get("result").toString());


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("eunmi" + json.get("result"));
                        System.out.println("eunmi" + result.get("token"));
                        System.out.println("eunmi" + result.get("userId"));
                        token =result.get("token").toString();
                        ID = result.get("userId").toString();
                        Name = result.get("userName").toString();
                        Major = result.get("major").toString();
                        AdmissionYear = result.get("admissionYear").toString();

                    }
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
        else if(flag==4){
            Toast.makeText(activity, result,
                    Toast.LENGTH_LONG).show();
            Toast.makeText(activity, "게시글 등록에 성공하였습니다.",
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