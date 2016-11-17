package com.example.curookie.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText num1,num2;
    Button sum,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        sum();
        sub();
        mul();
        div();

    }

    private void div() {
        div = (Button)findViewById(R.id.div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r;
                if(!num1.getText().toString().matches("^[0-9]+$")||!num2.getText().toString().matches("^[0-9]+$")) { Toast.makeText(getApplicationContext(),"값을 입력해주세요.",Toast.LENGTH_SHORT).show(); return; }
                if(Integer.parseInt(num1.getText().toString())==0) Toast.makeText(getApplicationContext(),r="0",Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(),r=String.format("%.2f",Double.parseDouble(num1.getText().toString())/Double.parseDouble(num2.getText().toString())),Toast.LENGTH_SHORT).show();
                result.setText("계산 결과 : "+r);
            }
        });
    }

    private void mul() {
        mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r;
                if(!num1.getText().toString().matches("^[0-9]+$")||!num2.getText().toString().matches("^[0-9]+$")) { Toast.makeText(getApplicationContext(),"값을 입력해주세요.",Toast.LENGTH_SHORT).show(); return; }
                Toast.makeText(getApplicationContext(),r=(Integer.parseInt(num1.getText().toString())*Integer.parseInt(num2.getText().toString())+""),Toast.LENGTH_SHORT).show();
                result.setText("계산 결과 : "+r);
            }
        });
    }

    private void sub() {
        sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r;
                if(!num1.getText().toString().matches("^[0-9]+$")||!num2.getText().toString().matches("^[0-9]+$")) { Toast.makeText(getApplicationContext(),"값을 입력해주세요.",Toast.LENGTH_SHORT).show(); return; }
                Toast.makeText(getApplicationContext(),r=(Integer.parseInt(num1.getText().toString())-Integer.parseInt(num2.getText().toString())+""),Toast.LENGTH_SHORT).show();
                result.setText("계산 결과 : "+r);
            }
        });
    }

    private void sum() {
        sum = (Button)findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r;
                if(!num1.getText().toString().matches("^[0-9]+$")||!num2.getText().toString().matches("^[0-9]+$")) { Toast.makeText(getApplicationContext(),"값을 입력해주세요.",Toast.LENGTH_SHORT).show(); return; }
                Toast.makeText(getApplicationContext(),r=(Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString())+""),Toast.LENGTH_SHORT).show();
                result.setText("계산 결과 : "+r);
            }
        });
    }

}
