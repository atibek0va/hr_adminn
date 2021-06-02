package com.example.hradmin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hradmin.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditRealEstateActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText healthcare;
    Button btnSave, btnCancel;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String emailformat;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_real_estate);
        healthcare = findViewById(R.id.healthcare);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){
            String hcare = healthcare.getText().toString();
            if (hcare.isEmpty()){
                healthcare.setError("Please, write about real state");
                return;
            }
            myRef.child("finance supports").child("realstate").setValue(hcare);
            Intent i = new Intent(getApplicationContext(), RealstateActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(EditRealEstateActivity.this, RealstateActivity.class));
        }
    }
}