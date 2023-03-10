package com.example.appresources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout1);
    }

    //Button Calculate A * B
    public void calculate(View view)
    {
        try {
            // get object EditText inputA from .xml
            EditText inputA = (EditText) findViewById(R.id.editTextInputA);
            //get object EditText inputB from .xml
            EditText inputB = (EditText) findViewById(R.id.editTextInputB);

            if (inputA.getText().toString().equals("") || inputB.getText().toString().equals(""))
            {
                inputA.setHint(getResources().getString(R.string.hint));
                inputB.setHint(getResources().getString(R.string.hint));

                EditText result = (EditText) findViewById(R.id.editTextResult);
                result.setText(Double.toString(0));
            }
            else
            {
                //get value in EditText
                String a_text = inputA.getText().toString();
                // Convert value from String to Double for calculation
                double a = Double.parseDouble(a_text);

                //get value in EditText
                String b_text = inputB.getText().toString();
                //Convert value from String to Double for calculation
                double b = Double.parseDouble(b_text);

                double multiply = a * b;
                //get object EditText of showing result and set the result of calculation onto display
                EditText result = (EditText) findViewById(R.id.editTextResult);
                result.setText(Double.toString(multiply));
            }
        }catch(Exception e)
        {
            Log.i("Error", e.toString());
        }
    }
}