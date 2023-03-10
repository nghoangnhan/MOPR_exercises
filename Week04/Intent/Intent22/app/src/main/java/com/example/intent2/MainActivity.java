package com.example.intent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.textView_result);
        mEditTextNumber1 = findViewById(R.id.editText_number1);
        mEditTextNumber2 = findViewById(R.id.editText_number2);
        
        Button btnOpenActivity2 = findViewById(R.id.btnOpenActivity2);
        btnOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber1.getText().toString().equals("")
                || mEditTextNumber2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
                }
                else {
                    int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                    int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    startActivityForResult(intent, 1);

                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mTextViewResult = findViewById(R.id.textView_result);
        System.out.println(resultCode);
        if(requestCode == 1){
            if (resultCode == RESULT_OK){
                Integer result = data.getIntExtra("result", 0);
                mTextViewResult.setText(result.toString());
            }
            if(resultCode == RESULT_CANCELED)
            {
                mTextViewResult.setText("Nothing selected");
            }
        }
    }
}