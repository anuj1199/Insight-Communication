package com.example.callingnsmsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
EditText e1,e2;
ImageButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(ImageButton)findViewById(R.id.imageButton3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager;
                    smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(e1.getText().toString(),null,e2.getText().toString()
                            ,null,null);
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
                    }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Message Sent!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
