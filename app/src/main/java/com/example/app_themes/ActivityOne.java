package com.example.app_themes;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sharedPref;

    private static final String NAME_SHARED_PREF_FILE = "NAME_SHARED_PREF_FILE";
    private static final String KEY_THEME = "KEY_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** ТЕМУ применяем ДО setContentView **/
        //setTheme(MyApp.currentTheme);
        setTheme(getAppTheme());
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
                //MyApp.currentTheme = R.style.myThemeGreen;
                setAppTheme(R.style.myThemeGreen);
                break;
            case R.id.rBtn_Blue:
                //MyApp.currentTheme = R.style.myThemeBlue;
                setAppTheme(R.style.myThemeBlue);
                break;
            case R.id.rBtn_Yellow:
                //MyApp.currentTheme = R.style.myThemeYellow;
                setAppTheme(R.style.myThemeYellow);
                break;
            case R.id.rBtn_Red:
                //MyApp.currentTheme = R.style.myThemeRed;
                setAppTheme(R.style.myThemeRed);
                break;
        }
        recreate();
    }

    /**
     * Устанавливаем и сохраняем тему
     **/
    @SuppressLint("CommitPrefEdits")
    protected void setAppTheme(int themeCode) {
        sharedPref = getSharedPreferences(NAME_SHARED_PREF_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(KEY_THEME, themeCode).apply();
    }

    /**
     * Получаем тему из сохраненных настроек (в Shared Pref)
     **/
    protected int getAppTheme() {
        sharedPref = getSharedPreferences(NAME_SHARED_PREF_FILE, MODE_PRIVATE);
        return sharedPref.getInt(KEY_THEME, R.style.myThemeDefault);
    }
}


