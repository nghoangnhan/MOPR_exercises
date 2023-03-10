package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Activity Life Cycle", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activity Life Cycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activity Life Cycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activity Life Cycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Activity Life Cycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Activity Life Cycle","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Activity Life Cycle", "onDestroy");
    }
}