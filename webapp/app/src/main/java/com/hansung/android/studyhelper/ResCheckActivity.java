package com.hansung.android.studyhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by leeem on 2018-12-18.
 */

public class ResCheckActivity extends AppCompatActivity {
    static ListView resc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescheck);

        resc = (ListView)findViewById(R.id.resc);

        new GetResCheck(ResCheckActivity.this).execute();
    }
}
