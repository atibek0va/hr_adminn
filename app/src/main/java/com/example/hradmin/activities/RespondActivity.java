package com.example.hradmin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.hradmin.R;
import com.example.hradmin.model.Respond;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RespondActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSubmit, btnCancel;
    TextInputEditText inputQuestion, inputDate;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respond);
        initViews();
    }

    public void initViews(     ){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        inputQuestion = findViewById(R.id.inputQuestion);
        inputDate = findViewById(R.id.inputDate);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSubmit){
            saveInfo();
            startActivity(new Intent(RespondActivity.this, MainPageActivity.class));
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(RespondActivity.this, MainPageActivity.class));
        }
    }

    public void saveInfo(){
        String uquestion = inputQuestion.getText().toString();
        String udate = inputDate.getText().toString();

        Respond respond = new Respond(uquestion, udate);

//        myRef.child("responds").child(udate).child("question responds").setValue(uquestion);
//        myRef.child("responds").child(udate).child("question responds date").setValue(udate);
        myRef.child("responds").child(udate).setValue(respond);
    }
}