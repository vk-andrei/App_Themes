package com.example.app_themes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** ТЕМУ применяем ДО setContentView **/
        setTheme(MyApp.currentTheme);
        /**************************************/
        setContentView(R.layout.activity_main);

        (findViewById(R.id.rBtn_Green)).setOnClickListener(this);
        RadioButton rBtnBlue = findViewById(R.id.rBtn_Blue);
        RadioButton rBtnYellow = findViewById(R.id.rBtn_Yellow);
        RadioButton rBtnRed = findViewById(R.id.rBtn_Red);

        //rBtnGreen.setOnClickListener(this);
        rBtnBlue.setOnClickListener(this);
        rBtnYellow.setOnClickListener(this);
        rBtnRed.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rBtn_Green:
                MyApp.currentTheme = R.style.myThemeGreen;
                break;
            case R.id.rBtn_Blue:
                MyApp.currentTheme = R.style.myThemeBlue;
                break;
            case R.id.rBtn_Yellow:
                MyApp.currentTheme = R.style.myThemeYellow;
                break;
            case R.id.rBtn_Red:
                MyApp.currentTheme = R.style.myThemeRed;
                break;
        }
        recreate();

    }
}