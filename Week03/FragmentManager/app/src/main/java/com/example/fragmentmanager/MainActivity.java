package com.example.fragmentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment firstFragment = new FirstFragment();
        Fragment secondFragment = new SecondFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.flFragment, firstFragment);
        ft.addToBackStack(null);
        ft.commit();

        Button btnFragment1 = (Button)findViewById(R.id.btnFragment1);
        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.flFragment, firstFragment);
                ft1.addToBackStack(null);
                ft1.commit();
            }
        });

        Button btnFragment2 = (Button)findViewById(R.id.btnFragment2);
        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                ft2.replace(R.id.flFragment, secondFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });
    }

}