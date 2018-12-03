package com.hansung.android.studyhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.hansung.android.studyhelper.MainActivity.login;

/**
 * Created by leeem on 2018-11-18.
 */

public class WriteActivity extends AppCompatActivity {

    final static String TAG = "AndroidNodeJS";
    final static String defaultUrl = "http://54.180.105.16:80/boards";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Button insertBtn2 = (Button) findViewById(R.id.sub);
        insertBtn2.setOnClickListener(new MyOnClickListener());

    }

    private class MyOnClickListener implements View.OnClickListener {

        public void onClick(View view) {

            EditText edit_jemoc = (EditText) findViewById(R.id.jemoc);
            Spinner countspinner = (Spinner) findViewById(R.id.countspinner);
            EditText edit_neyoung = (EditText) findViewById(R.id.neyoung2);

            SimpleDateFormat df;
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
            String str_date = df.format(new Date());



            JSONObject postDataParam = new JSONObject();
            try {
                postDataParam.put("userId", SignInActivity.ID);
                postDataParam.put("boardTitle", edit_jemoc.getText().toString());
                postDataParam.put("boardDate", str_date);
                postDataParam.put("memberCount", Integer.parseInt(countspinner.toString()));
            } catch (JSONException e) {
                Log.e(TAG, "JSONEXception");
            }
            new InsertData(WriteActivity.this).execute(postDataParam);
            MainActivity.flag = 4;

            if(login==4) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            // new GetData(RegisterActivity.this).execute();
        }
    }
}
