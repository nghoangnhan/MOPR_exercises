package com.example.backgroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStartService;
    Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService = findViewById(R.id.btn_startService);
        btnStopService = findViewById(R.id.btn_stopService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStartService(view);
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStopService(view);
            }
        });
    }
    private void clickStartService(View view)
    {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
    private void clickStopService(View view)
    {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}