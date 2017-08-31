package com.parag.mvcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer,View.OnClickListener {

    Model mModel;
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel = new Model();
        mModel.addObserver(this);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.i("xxx",""+mModel.getCountAtPosition(0)+" , "+mModel.getCountAtPosition(1)+" , "+mModel.getCountAtPosition(2));
        btn1.setText("Count : "+mModel.getCountAtPosition(0));
        btn2.setText("Count : "+mModel.getCountAtPosition(1));
        btn3.setText("Count : "+mModel.getCountAtPosition(2));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn1:
                mModel.setCountAtPosition(0);
                break;
            case R.id.btn2:
                mModel.setCountAtPosition(1);
                break;
            case R.id.btn3:
                mModel.setCountAtPosition(2);
                break;
        }
    }
}
