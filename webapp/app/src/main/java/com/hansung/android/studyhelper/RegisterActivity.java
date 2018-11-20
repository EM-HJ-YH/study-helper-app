package com.hansung.android.studyhelper;

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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by leeem on 2018-11-12.
 */

public class RegisterActivity extends AppCompatActivity {

    final static String TAG = "AndroidNodeJS";
    final static String defaultUrl = "http://54.180.105.16:80";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


               Button insertBtn = (Button) findViewById(R.id.go);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_mypage);

                EditText edit_name = (EditText) findViewById(R.id.editname);
                EditText edit_id = (EditText) findViewById(R.id.editid);
                EditText edit_pw = (EditText) findViewById(R.id.editpw);
                final RadioGroup rgp1 = (RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton rm1 = (RadioButton) findViewById(R.id.radiomajor1);
                RadioButton rm2 = (RadioButton) findViewById(R.id.radiomajor2);
                RadioButton rm3 = (RadioButton) findViewById(R.id.radiomajor3);
                RadioButton rm4 = (RadioButton) findViewById(R.id.radiomajor4);
                RadioButton rm5 = (RadioButton) findViewById(R.id.radiomajor5);
                final RadioGroup rgp2 = (RadioGroup)findViewById(R.id.radioGroup2);
                RadioButton rg1 = (RadioButton) findViewById(R.id.radiograde1);
                RadioButton rg2 = (RadioButton) findViewById(R.id.radiograde2);
                RadioButton rg3 = (RadioButton) findViewById(R.id.radiograde3);
                RadioButton rg4 = (RadioButton) findViewById(R.id.radiograde4);
                int id = rgp1.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(id);
                int id2 = rgp2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton) findViewById(id2);

                JSONObject postDataParam = new JSONObject();
                try {
                    postDataParam.put("userName", edit_name.getText().toString());
                    postDataParam.put("userId", edit_id.getText().toString());
                    postDataParam.put("userPw", edit_pw.getText().toString());
                    postDataParam.put("major", rb.getText().toString());
                    postDataParam.put("admissionYear", rb2.getText().toString());
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new InsertData(RegisterActivity.this).execute(postDataParam);
                new GetData(RegisterActivity.this).execute();


            }
        });

    }
}
