package com.hansung.android.studyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import static com.hansung.android.studyhelper.MainActivity.flag;
import static com.hansung.android.studyhelper.MyTeamActivity.b2;
import static com.hansung.android.studyhelper.MyTeamActivity.c2;
import static com.hansung.android.studyhelper.MyTeamActivity.d2;

/**
 * Created by leeem on 2018-12-14.
 */

public class TeamBoardActivity extends AppCompatActivity {
    static ListView teamboardview;
    final static String defaultUrl = "http://54.180.105.16:80/groupBoards";

    protected void onCreate(Bundle savedInstanceState) {
        flag=11;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamboard);
        new GetTeamBoard(TeamBoardActivity.this).execute();
        TextView gmn = (TextView) findViewById(R.id.gmn);
        TextView gn = (TextView) findViewById(R.id.gn);
        TextView m = (TextView) findViewById(R.id.m);

        gmn.setText(b2);
        gn.setText(c2);
        m.setText(d2);

        teamboardview = (ListView)findViewById(R.id.teamboardview);

        Button groupwrite = (Button)findViewById(R.id.groupwrite);
        groupwrite.setOnClickListener(new TeamBoardActivity.MyOnClickListener2());

    }

    private class MyOnClickListener2 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "그룹 게시글 등록 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), GroupBoardWriteActivity.class);
            startActivity(intent);
        }
    }

}
