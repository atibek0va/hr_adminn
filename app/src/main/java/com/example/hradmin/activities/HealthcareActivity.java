package com.example.hradmin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hradmin.R;
import com.example.hradmin.model.Job;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HealthcareActivity extends AppCompatActivity {

    FloatingActionButton floatBtn;
    TextView abtHealth;

    DatabaseReference myRef;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare);

        database = FirebaseDatabase.getInstance();

        abtHealth = findViewById(R.id.abtHealth);
//        myRef.child("finance supports").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    for(DataSnapshot support: snapshot.getChildren()) {
//                        String aboutHealthcare = support.child("healthcare").getValue().toString();
//                        abtHealth.setText(aboutHealthcare);
//                    }
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        floatBtn = findViewById(R.id.btnFloat);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthcareActivity.this, EditHealthcareActivity.class));
            }
        });
    }
}