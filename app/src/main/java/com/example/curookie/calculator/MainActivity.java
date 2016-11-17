package com.example.curookie.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    Button sum,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        sum();
        sub();
        mul();

    }

    private void mul() {
        mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),Integer.parseInt(num1.getText().toString())*Integer.parseInt(num2.getText().toString())+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sub() {
        sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),Integer.parseInt(num1.getText().toString())-Integer.parseInt(num2.getText().toString())+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sum() {
        sum = (Button)findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString())+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
