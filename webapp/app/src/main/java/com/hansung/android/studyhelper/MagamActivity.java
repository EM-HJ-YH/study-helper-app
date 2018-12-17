package com.hansung.android.studyhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import static com.hansung.android.studyhelper.MainActivity.h;

/**
 * Created by leeem on 2018-12-17.
 */

public class MagamActivity extends AppCompatActivity {

    final static String defaultUrl = "http://54.180.105.16:80/groups";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magam);




        Button insertBtn2 = (Button) findViewById(R.id.sub3);
        insertBtn2.setOnClickListener(new MyOnClickListener122());


    }
    private class MyOnClickListener122 implements View.OnClickListener {

        public void onClick(View view) {
            EditText grname2 = (EditText) findViewById(R.id.grname2);

            JSONObject postDataParam2 = new JSONObject();
            try {
                postDataParam2.put("groupIndex", 0);
                postDataParam2.put("groupMasterId", localstorage.ID);
                postDataParam2.put("groupName",grname2.getText().toString()) ;
                postDataParam2.put("members", h);
                MainActivity.flag = 9;

            } catch (JSONException e) {
               // Log.e(TAG, "JSONEXception");
            }
            new InsertData(MagamActivity.this).execute(postDataParam2);
        }
        }

}
