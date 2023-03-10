package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicBoundService extends Service {

    private MyBinder myBinder = new MyBinder();
    private MediaPlayer mediaPlayer;

    public class MyBinder extends Binder{
        MusicBoundService getMusicBoundService()
        {
            return MusicBoundService.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MusicBoundService", "onBind");
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MusicBoundService", "onCreate");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MusicBoundService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("MusicBoundService", "onDestroy");
        super.onDestroy();
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void startMusic() {
        if(mediaPlayer == null)
        {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.file_mp3);
        }
        mediaPlayer.start();

    }
}
