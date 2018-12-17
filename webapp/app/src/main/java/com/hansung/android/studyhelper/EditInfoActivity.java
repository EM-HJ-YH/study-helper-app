package com.hansung.android.studyhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by leeem on 2018-12-17.
 */

public class EditInfoActivity extends AppCompatActivity {

    static String q=null;
    static int w = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);

        Button  editBtn2 = (Button) findViewById(R.id.sub21);
        editBtn2.setOnClickListener(new MyOnClickListener111());

    }

    private class MyOnClickListener111 implements View.OnClickListener {

        public void onClick(View view) {

            TextView useridd = (TextView) findViewById(R.id.useridd);
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

            useridd.setText(localstorage.ID);
            q= rb.getText().toString();
            w=Integer.parseInt(rb2.getText().toString());

            JSONObject postDataParam = new JSONObject();
            try {
                postDataParam.put("userId", localstorage.ID);
                postDataParam.put("major", rb.getText().toString());
                postDataParam.put("admissionYear", Integer.parseInt(rb2.getText().toString()));
            } catch (JSONException e) {
                //Log.e(TAG, "JSONEXception");
            }
            MainActivity.flag = 18;
            new EditData(EditInfoActivity.this).execute(postDataParam);


        }
        }

}
