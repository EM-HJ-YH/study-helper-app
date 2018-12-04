package com.hansung.android.studyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by leeem on 2018-11-18.
 */

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Button sub1 = (Button) findViewById(R.id.sub1);
        sub1.setOnClickListener(new DetailActivity.MyOnClickListener());
    }

    private class MyOnClickListener implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "해당 팀에 신청이 완료되었습니다..",
                    Toast.LENGTH_SHORT).show();

            Intent intent3 = new Intent(getApplicationContext(), MyTeamActivity.class);
            startActivity(intent3);
        }
    }
}
