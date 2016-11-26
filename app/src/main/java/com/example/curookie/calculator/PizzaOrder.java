package com.example.curookie.calculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PizzaOrder extends AppCompatActivity {

    Button btnSubmit;
    EditText or1,or2,or3;
    RadioGroup rg;
    CheckBox cb1;
    ImageView iv;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order);
        setTitle("피자 주문");

        initId();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButton7) iv.setImageResource(R.drawable.pickle);
                else iv.setImageResource(R.drawable.source);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if(!or1.getText().toString().matches("^[0-9]+$")||!or2.getText().toString().matches("^[0-9]+$")||!or3.getText().toString().matches("^[0-9]+$")) {
                    Toast.makeText(getApplicationContext(),"주문 항목을 입력해주세요~",Toast.LENGTH_SHORT).show();
                    return;
                }
                int o1 = Integer.parseInt(or1.getText().toString());
                int o2 = Integer.parseInt(or2.getText().toString());
                int o3 = Integer.parseInt(or3.getText().toString());
                int sale = (int) Math.round((o1*16000+o2*11000+o3*4000)*0.93/10)*10;
                String opt="피클";
                if(rg.getCheckedRadioButtonId()==R.id.radioButton8) opt = "소스";

                DecimalFormat df = new DecimalFormat("#,##0");

                tv1.setText("주문 개수 : "+(o1+o2+o3));
                if(cb1.isChecked()) tv2.setText("주문 금액 : "+df.format(sale)+"원");
                else tv2.setText("주문 금액 : "+df.format((o1*16000+o2*11000+o3*4000))+"원");
                tv3.setText(opt+"을 선택하셨습니다.");
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
                Intent intent = new Intent(PizzaOrder.this, MainActivity.class);
                startActivity(intent);
            break;
            case 101 :
                Intent intent2 = new Intent(PizzaOrder.this, Main2Activity.class);
                startActivity(intent2);
            break;
            case 102 :
                Intent intent3 = new Intent(PizzaOrder.this, AndroidPhotoView.class);
                startActivity(intent3);
                break;
            case 103 :
                Intent intent4 = new Intent(PizzaOrder.this, PizzaOrder.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initId() {
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        or1 = (EditText) findViewById(R.id.order1);
        or2 = (EditText) findViewById(R.id.order2);
        or3 = (EditText) findViewById(R.id.order3);
        rg = (RadioGroup) findViewById(R.id.option_rg);
        cb1 = (CheckBox) findViewById(R.id.point);
        tv1 = (TextView) findViewById(R.id.ortxt1);
        tv2 = (TextView) findViewById(R.id.ortxt2);
        tv3 = (TextView) findViewById(R.id.ortxt3);
        iv = (ImageView) findViewById(R.id.imageView3);
    }
}
