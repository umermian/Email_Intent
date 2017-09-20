package com.example.popie.email_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText email , subject , message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));

        email = (EditText) findViewById(R.id.emailID);
        subject = (EditText) findViewById(R.id.subject);
        message = (EditText) findViewById(R.id.message);

        String mail = email.getText().toString();

        String[] to = {mail};

        intent.putExtra(Intent.EXTRA_EMAIL , to);
        intent.putExtra(Intent.EXTRA_SUBJECT , subject.getText());
        intent.putExtra(Intent.EXTRA_TEXT , message.getText());

        intent.setType("message/rfc822");

        startActivity(intent);



    }
}
