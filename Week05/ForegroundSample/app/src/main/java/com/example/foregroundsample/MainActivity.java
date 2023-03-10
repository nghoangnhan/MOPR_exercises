package com.example.foregroundsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtDataIntent;
    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDataIntent = findViewById(R.id.editText_dataIntent);
        btnStartService = findViewById(R.id.btn_startService);
        btnStopService = findViewById(R.id.btn_stopService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStartService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStopService();
            }
        });
    }

    private void clickStartService()
    {
        Song song = new Song("If you said so", "Coldzy, 2pillz, tlinh", R.drawable.img_music, R.raw.file_mp3);

        Intent intent = new Intent(this, MyService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", song);
        intent.putExtras(bundle);

        startService(intent);
    }
    private void clickStopService()
    {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }


}