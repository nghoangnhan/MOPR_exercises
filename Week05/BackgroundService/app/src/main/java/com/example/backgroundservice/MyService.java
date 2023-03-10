package com.example.backgroundservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends IntentService {
    /**
     * @param
     * @deprecated
     */
    public MyService() {
        super("my_intent_thread");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {

        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this, "Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this)
        {
            try{
                wait(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
