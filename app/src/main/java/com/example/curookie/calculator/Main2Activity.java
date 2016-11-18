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
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    CheckBox cb;
    RadioGroup rg;
    Button btnSelect;
    ImageView iv;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("애완동물 사진 보기");

        initId();

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==R.id.radioButton) iv.setImageResource(R.drawable.dog);
                else if(rg.getCheckedRadioButtonId()==R.id.radioButton2) iv.setImageResource(R.drawable.cat);
                else if(rg.getCheckedRadioButtonId()==R.id.radioButton3) iv.setImageResource(R.drawable.rabbit);
            }
        });

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
        btnSelect = (Button) findViewById(R.id.btnSelect);
        iv = (ImageView) findViewById(R.id.imageView);
        ll = (LinearLayout)findViewById(R.id.linear);
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}
