package com.example.hradmin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hradmin.R;
import com.example.hradmin.model.Employee;
import com.example.hradmin.model.Job;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewJobActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    Button btnSave, btnCancel;
    EditText jobName, jobSalary, jobTime;

    DatabaseReference myRef;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);
        initViews();
    }

    public void initViews(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        jobName = findViewById(R.id.jobName);
        jobSalary = findViewById(R.id.jobSalary);
        jobTime = findViewById(R.id.jobTime);


        btnBack = findViewById(R.id.back);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){
            String jname = jobName.getText().toString();
            String jsalary = jobSalary.getText().toString();
            String jtime = jobTime.getText().toString();
            if (jname.isEmpty()){
                jobName.setError("Job name is requied");
                return;
            }
            if (jsalary.isEmpty()){
                jobSalary.setError("Job salary is requied");
                return;
            }
            if (jtime.isEmpty()){
                jobTime.setError("Job time is requied");
                return;
            }
            Job job = new Job(jname, jsalary, jtime);
            myRef.child("jobs").child(jname).setValue(job);
            Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
            startActivity(i);
            Toast.makeText(NewJobActivity.this, "New job succeddfully added", Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(NewJobActivity.this, MainPageActivity.class));
        }else if (v.getId() == R.id.back){
            startActivity(new Intent(NewJobActivity.this, MainPageActivity.class));
        }
    }

}