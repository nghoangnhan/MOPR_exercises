package com.example.intent3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivedIntent = getIntent();
        Uri uri = receivedIntent.getData();
        URL webPageURL = null;

        if (uri != null) {
            try {
                webPageURL = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            } catch (Exception e) {
                Toast.makeText(this, "Intent excetion occured", Toast.LENGTH_SHORT).show();
            }
            WebView webview = findViewById(R.id.webview);
            webview.setWebViewClient(new WebViewClient());
            webview.loadUrl(webPageURL.toString());
        }
    }


}