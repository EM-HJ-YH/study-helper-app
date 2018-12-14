package com.hansung.android.studyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.hansung.android.studyhelper.MainActivity.a;
import static com.hansung.android.studyhelper.MainActivity.b;
import static com.hansung.android.studyhelper.MainActivity.c;
import static com.hansung.android.studyhelper.MainActivity.d;
import static com.hansung.android.studyhelper.MainActivity.e;
import static com.hansung.android.studyhelper.MainActivity.f;
import static com.hansung.android.studyhelper.MainActivity.flag;
import static com.hansung.android.studyhelper.MainActivity.g;
import static com.hansung.android.studyhelper.MainActivity.h;

/**
 * Created by leeem on 2018-11-18.
 */

public class DetailActivity extends AppCompatActivity {
    final static String defaultUrl = "http://54.180.105.16:80/boards";
    String members=localstorage.ID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView jemoc = (TextView) findViewById(R.id.jemoc);
        TextView userr = (TextView) findViewById(R.id.userr);
        TextView countt = (TextView) findViewById(R.id.countt);
        TextView datee = (TextView)findViewById(R.id.datee);
        TextView neyoung2 = (TextView) findViewById(R.id.neyoung2);
        TextView mn = (TextView) findViewById(R.id.mn);
        TextView mojipjung = (TextView) findViewById(R.id.mojipjung);
        String mojip="true";
        if(g==false){
            mojip="false";
        }
        jemoc.setText(b);
        userr.setText(c);
        datee.setText(d);
        neyoung2.setText(e);
        countt.setText(f);
        mn.setText(h);
        mojipjung.setText(mojip);

        Button sub1 = (Button) findViewById(R.id.sub1);
        sub1.setOnClickListener(new DetailActivity.MyOnClickListener());
    }

    private class MyOnClickListener implements View.OnClickListener {
        public void onClick(View view) {

            JSONObject postDataParam2 = new JSONObject();
            try {
                postDataParam2.put("members", members);
                flag=10;

            } catch (JSONException e) {
               // Log.e(TAG, "JSONEXception");
            }
            new InsertData(DetailActivity.this).execute(postDataParam2);
            Toast.makeText(getApplicationContext(),
                    "해당 팀에 신청이 완료되었습니다..",
                    Toast.LENGTH_SHORT).show();

        }
    }
}
