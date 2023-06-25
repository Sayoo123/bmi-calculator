package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText height,weight,value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height= (EditText)findViewById(R.id.height);
        weight= (EditText)findViewById(R.id.weight);
        value= (EditText)findViewById(R.id.value);
    }
    public void calc(View v){
        float res;
        float h=Float.parseFloat(height.getText().toString());
        float w=Float.parseFloat(weight.getText().toString());
        res=((w/h)/h)*10000;
        String mytext=Float.toString(res);
        value.setText(mytext);
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
        if(res<18.5)
        {
            Toast toast = Toast.makeText(this /* MyActivity */, "underweight",Toast.LENGTH_LONG);
            toast.show();
        } else if (res>18.5&&res<24.9) {
            Toast toast = Toast.makeText(this /* MyActivity */, "Healthy-weight",Toast.LENGTH_LONG);
            toast.show();
        }
        else if(res>25.0&&res<29.9)
        {
            Toast toast = Toast.makeText(this /* MyActivity */, "OverWeight",Toast.LENGTH_LONG);
            toast.show();

        }
        else {
            Toast toast = Toast.makeText(this /* MyActivity */, "Obesity",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}