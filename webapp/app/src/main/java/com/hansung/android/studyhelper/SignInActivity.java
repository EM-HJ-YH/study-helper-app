package com.hansung.android.studyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;
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

import org.json.JSONException;
import org.json.JSONObject;

import static com.hansung.android.studyhelper.MainActivity.login;

public class SignInActivity extends AppCompatActivity {

        final static String TAG = "AndroidNodeJS";
        final static String defaultUrl = "http://54.180.105.16:80/signinUser";


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);


            Button inserBtn = (Button) findViewById(R.id.signin2);
            inserBtn.setOnClickListener(new SignInActivity.MyOnClickListener11());


        }

        private class MyOnClickListener11 implements View.OnClickListener {

            public void onClick(View view) {


                EditText edit_id = (EditText) findViewById(R.id.editSid);
                EditText edit_pw = (EditText) findViewById(R.id.editSpw);
                JSONObject postDataParam = new JSONObject();
                try {

                    postDataParam.put("userId", edit_id.getText().toString());
                    postDataParam.put("userPw", edit_pw.getText().toString());

                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }


                new InsertData(SignInActivity.this).execute(postDataParam);
               // new GetData(SignInActivity.this).execute();

                MainActivity.flag = 2;
                if(login==3) {
                    //new GetData(SignInActivity.this).execute();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }


            }
        }
    }
