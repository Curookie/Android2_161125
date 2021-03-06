package com.example.curookie.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class AndroidPhotoView extends AppCompatActivity {


    Switch btnStart;
    LinearLayout linearLayout;
    RadioGroup rg;
    RadioButton rb;
    ImageView iv;
    Button btnExit, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_photo_view);
        setTitle("안드로이드 사진 보기");

        initId();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
               if(i==R.id.radioButton4) iv.setImageResource(R.drawable.jellybean);
               else if (i==R.id.radioButton5) iv.setImageResource(R.drawable.kitkat);
               else if (i==R.id.radioButton6) iv.setImageResource(R.drawable.lolipop);
           }
        });

        btnStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              if (b) linearLayout.setVisibility(View.VISIBLE);
                        else linearLayout.setVisibility(View.INVISIBLE);
                    }
                });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setChecked(true);
                btnStart.setChecked(false);
                linearLayout.setVisibility(View.INVISIBLE);

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,100,0, "계산기");
        menu.add(0,101,0, "애완 동물 사진 보기");
        menu.add(0,102,0, "안드로이드 사진 보기");
        menu.add(0,103,0, "피자 주문");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 100 :
                Intent intent = new Intent(AndroidPhotoView.this, MainActivity.class);
                startActivity(intent);
                break;
            case 101 :
                Intent intent2 = new Intent(AndroidPhotoView.this, Main2Activity.class);
                startActivity(intent2);
                break;
            case 102 :
                Intent intent3 = new Intent(AndroidPhotoView.this, AndroidPhotoView.class);
                startActivity(intent3);
                break;
            case 103 :
                Intent intent4 = new Intent(AndroidPhotoView.this, PizzaOrder.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initId() {
        btnStart = (Switch) findViewById(R.id.switch1);
        linearLayout = (LinearLayout) findViewById(R.id.switchLinear);
        rg = (RadioGroup) findViewById(R.id.android_rg);
        rb = (RadioButton) findViewById(R.id.radioButton4);
        iv = (ImageView) findViewById(R.id.imageView2);
        btnExit = (Button) findViewById(R.id.button);
        btnReset = (Button) findViewById(R.id.button2);
    }
}
