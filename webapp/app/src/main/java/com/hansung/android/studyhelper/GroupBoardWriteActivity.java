package com.hansung.android.studyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.hansung.android.studyhelper.MyTeamActivity.a2;
import static com.hansung.android.studyhelper.MyTeamActivity.c2;

/**
 * Created by leeem on 2018-12-15.
 */

public class GroupBoardWriteActivity extends AppCompatActivity {

    final static String TAG = "AndroidNodeJS";
    final static String defaultUrl = "http://54.180.105.16:80/groupBoards";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupboardwrite);

        Button insertBtn3 = (Button) findViewById(R.id.boardsub);
        insertBtn3.setOnClickListener(new MyOnClickListener11111());

    }

    private class MyOnClickListener11111 implements View.OnClickListener {

        public void onClick(View view) {

            EditText boardtitle = (EditText) findViewById(R.id.boardtitle2);
            EditText boardcontent = (EditText) findViewById(R.id.boardcontent2);

            SimpleDateFormat df;
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
            String str_date = df.format(new Date());



            JSONObject postDataParam3 = new JSONObject();
            try {
                postDataParam3.put("groupBoardIndex", 0);
                postDataParam3.put("groupIndex", a2);
                postDataParam3.put("groupName", c2);
                postDataParam3.put("groupBoardTitle", boardtitle.getText().toString());
                postDataParam3.put("groupBoardContent",boardcontent.getText().toString()) ;
                postDataParam3.put("groupBoardPosterId", localstorage.ID);
                postDataParam3.put("groupBoardDate", str_date);

                MainActivity.flag = 11;

            } catch (JSONException e) {
                Log.e(TAG, "JSONEXception");
            }
            new InsertData(GroupBoardWriteActivity.this).execute(postDataParam3);
            new GetTeamBoard(GroupBoardWriteActivity.this).execute();

            Intent intent111 = new Intent(getApplicationContext(), TeamBoardActivity.class);
            startActivity(intent111);




            // new GetData(RegisterActivity.this).execute();
        }
    }
}
