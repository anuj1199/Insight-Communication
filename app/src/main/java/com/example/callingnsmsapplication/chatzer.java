package com.example.callingnsmsapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;


import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class chatzer extends AppCompatActivity {
    EditText msg;
    ImageButton imageView;
    ListView listView;
    chat chat1;
    ArrayList<String>msglist;
    ArrayAdapter <String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatzer);

        msg=(EditText)findViewById(R.id.editText);
        imageView=(ImageButton)findViewById(R.id.imageButton);
        Firebase.setAndroidContext(this);
        final Firebase ref=new Firebase("https://allahkachamatkar.firebaseio.com/user");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat chat= new chat("Matanuj",msg.getText().toString(),"222");
                ref.push().setValue(chat);
                msg.setText("");

            }
        });
        chat1=new chat();
        listView=(ListView)findViewById(R.id.listview);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference mref=firebaseDatabase.getReference("user");
        msglist= new ArrayList<>();
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_layout,R.id.textView2,msglist);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                msglist.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    chat1=ds.getValue(chat.class);
                    msglist.add(chat1.getUsername()+":\n"+chat1.getMessage());

                }listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
