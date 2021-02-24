package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button sendMessage, setBackground;
    private EditText editText;
    private Intent intentMessage, intentSetBackground;
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.plain_text_input);
        sendMessage = findViewById(R.id.button);
        intentMessage = new Intent(this, SecondActivity.class);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                intentMessage.putExtra("testString", s);
                startActivity(intentMessage);
            }
        });

        setBackground = findViewById(R.id.button2);
        intentSetBackground = new Intent(this, ThirdActivity.class);

        setBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intentSetBackground, REQUEST_CODE);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    int imageId = extras.getInt("imageID");
                    ConstraintLayout currentLayout = findViewById(R.id.main_layout);
                    currentLayout.setBackground(getDrawable(imageId));
                }
            }
        }
}