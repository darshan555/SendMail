package com.example.sendmailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText toText;
    private EditText subjectText;
    private EditText messageText;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toText = findViewById(R.id.toED);
        subjectText = findViewById(R.id.subED);
        messageText = findViewById(R.id.messageED);
        send = findViewById(R.id.sendBTN);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }
    private void sendMail(){
        String recipientList = toText.getText().toString();
        String[] recipient = recipientList.split(",");
        String subject = subjectText.getText().toString();
        String message = messageText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(intent);
    }
}