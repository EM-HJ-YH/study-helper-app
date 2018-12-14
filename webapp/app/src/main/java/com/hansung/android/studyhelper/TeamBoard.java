package com.hansung.android.studyhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.hansung.android.studyhelper.MyTeamActivity.b2;
import static com.hansung.android.studyhelper.MyTeamActivity.c2;
import static com.hansung.android.studyhelper.MyTeamActivity.d2;

/**
 * Created by leeem on 2018-12-14.
 */

public class TeamBoard extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamboard);

        TextView gmn = (TextView) findViewById(R.id.gmn);
        TextView gn = (TextView) findViewById(R.id.gn);
        TextView m = (TextView) findViewById(R.id.m);

        gmn.setText(b2);
        gn.setText(c2);
        m.setText(d2);
    }

}
