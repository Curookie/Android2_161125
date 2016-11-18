package com.example.curookie.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result;
    EditText num1,num2;
    Button sum,sub,mul,div,mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기(수정)");

        result = (TextView)findViewById(R.id.result);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        sum();
        sub();
        mul();
        div();
        mod();

    }

    private void div() {
        div = (Button)findViewById(R.id.div);
        div.setOnClickListener(this);
    }

    private void mul() {
        mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(this);
    }

    private void sub() {
        sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(this);
    }

    private void sum() {
        sum = (Button)findViewById(R.id.sum);
        sum.setOnClickListener(this);
    }

    private void mod() {
        mod = (Button)findViewById(R.id.mod);
        mod.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(!num1.getText().toString().matches("^[+-]?\\d+(\\.?\\d*)$")||!num2.getText().toString().matches("^[+-]?\\d+(\\.?\\d*)$")) { Toast.makeText(getApplicationContext(),"값을 입력해주세요.",Toast.LENGTH_SHORT).show(); return; }
        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());
        double dresult = 0;

        if(view.getId()==R.id.sum) dresult=number1+number2;

        else if(view.getId()==R.id.sub) dresult=number1-number2;

        else if(view.getId()==R.id.mul) dresult=number1*number2;

        else if(view.getId()==R.id.div) {
            if(Double.parseDouble(num1.getText().toString())==0.0) { Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_SHORT).show(); result.setText("계산 결과 : 0"); return; }
            dresult=number1/number2;
        }

        else if(view.getId()==R.id.mod) dresult=number1%number2;

        Toast.makeText(getApplicationContext(),String.format("%.2f",dresult),Toast.LENGTH_SHORT).show();
        result.setText("계산 결과 : "+   String.format("%.2f",dresult));
    }
}
