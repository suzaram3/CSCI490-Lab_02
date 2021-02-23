package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    private Button sendMessage, setBackground;
    private Intent intentMessage, intentSetBackground;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.plain_text_input);
        sendMessage = findViewById(R.id.button);
        intentMessage = new Intent(this, SecondActivity.class);
        intentSetBackground = new Intent(this, ThirdActivity.class);


        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                intentMessage.putExtra("testString", s);
                startActivity(intentMessage);
            }
        });

//        setBackground.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivityForResult(intentSetBackground, 1);
//            }
//        });

    }
}