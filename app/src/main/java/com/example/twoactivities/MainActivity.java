package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView mreplyHeadTextView;
    private TextView mreplyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mreplyHeadTextView = findViewById(R.id.text_header_reply);
        mreplyView = findViewById(R.id.text_message_repply);
        

    }

    public void LaunchSecondActivity(View view) {
        Log.d( "Button Clicked ",  "Button Clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                assert data != null;
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mreplyHeadTextView.setVisibility(View.VISIBLE);
                mreplyView.setText(reply);
                mreplyView.setVisibility(View.VISIBLE);
            }
        }
    }
}