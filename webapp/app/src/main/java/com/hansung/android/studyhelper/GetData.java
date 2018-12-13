package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-11-20.
 */

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.System.out;
import static com.hansung.android.studyhelper.localstorage.ID;
/**
 * Created by kwanwoo on 2017. 10. 17..
 */

public class GetData extends GetRequest {
    public GetData(Activity activity) {
        super(activity);
    }

    static String name;
    static String id2;
    static String pw;
    static String major;
    static int admissionyear;



    @Override
    protected void onPreExecute() {

        String serverURLStr = RegisterActivity.defaultUrl.toString();
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
        ArrayList<Regist> arrayList= getArrayListFromJSONString(jsonString);
       // ArrayAdapter adapter = new ArrayAdapter(activity,
              //  android.R.layout.simple_list_item_1,
              //  arrayList.toArray());
       // ListView txtList = MypageActivity.txtview;
      //  txtList.setAdapter(adapter);
       // txtList.setDividerHeight(10);

    }


    protected ArrayList<Regist> getArrayListFromJSONString(String jsonString) {
        ArrayList<Regist> output = new ArrayList();
        try {
            System.out.println("Lee1");
            JSONArray jsonArray = new JSONArray(jsonString);
            System.out.println("Lee1");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                Regist regist = new Regist(jsonObject.getString("userName"),
                        jsonObject.getString("userId"),
                        jsonObject.getString("userPw"),
                        jsonObject.getString("major"),
                        jsonObject.getInt("admissionYear"));
                if(regist.userId==ID) {
                    name = regist.userName;
                    id2 = regist.userId;
                    pw = regist.userPw;
                    major = regist.major;
                    admissionyear = regist.admissionYear;
                }
                output.add(regist);
                }


            } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return output;
    }
}