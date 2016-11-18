package com.example.curookie.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    CheckBox cb;
    RadioButton rb1, rb2, rb3;
    Button btnSelect;
    ImageView iv;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("애완동물 사진 보기");

        initId();

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    ll.setVisibility(View.VISIBLE);
                } else {
                    ll.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    private void initId() {
        cb = (CheckBox) findViewById(R.id.checkBox);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        iv = (ImageView) findViewById(R.id.imageView);
        ll = (LinearLayout)findViewById(R.id.linear);
    }
}
