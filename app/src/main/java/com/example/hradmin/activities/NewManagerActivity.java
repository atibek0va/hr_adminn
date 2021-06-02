package com.example.hradmin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewManagerActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    Button btnSave, btnCancel;
    LinearLayout ll10, ll11;
    EditText inputName, inputPost, inputIIN, inputTelNumber, inputAddress, inputEmail, inputPassword;
    TextView personInfo;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String emailformat;
    FirebaseAuth auth;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_manager);
        initViews();
        setAnimation();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );
    }
    public void initViews(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ll10 = findViewById(R.id.linearLayout10);
        ll11 = findViewById(R.id.linearLayout11);

        inputName = findViewById(R.id.name);
        inputPost = findViewById(R.id.post);
        inputIIN = findViewById(R.id.iin);

        inputTelNumber = findViewById(R.id.telnumber);
        inputAddress = findViewById(R.id.address);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnBack = findViewById(R.id.back);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        personInfo = findViewById(R.id.personInfo);

        btnSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        String uname = inputName.getText().toString();
        String upost = inputPost.getText().toString();
        String uiin = inputIIN.getText().toString();
        String utelnum = inputTelNumber.getText().toString();
        String uaddress = inputAddress.getText().toString();
        String uemail = inputEmail.getText().toString();
        String upassword = inputPassword.getText().toString();

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        ll10.setAnimation(from_left);
        ll11.setAnimation(from_left);
        inputName.setAnimation(from_right);
        inputPost.setAnimation(from_right);
        inputIIN.setAnimation(from_right);
        inputAddress.setAnimation(from_right);
        inputTelNumber.setAnimation(from_right);
        inputEmail.setAnimation(from_right);
        inputPassword.setAnimation(from_right);
        btnSave.setAnimation(from_bottom);
        btnCancel.setAnimation(from_bottom);
        personInfo.setAnimation(from_right);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){
            String uname = inputName.getText().toString();
            String upost = inputPost.getText().toString();
            String uiin = inputIIN.getText().toString();
            String utelnum = inputTelNumber.getText().toString();
            String uaddress = inputAddress.getText().toString();
            String uemail = inputEmail.getText().toString();
            String upassword = inputPassword.getText().toString();
            if (uname.isEmpty()){
                inputName.setError("Full name is requied");
                return;
            }
            if (upost.isEmpty()){
                inputPost.setError("Post is requied");
                return;
            }
            if (uiin.isEmpty()){
                inputIIN.setError("IIN is requied");
                return;
            }
            if (utelnum.isEmpty()){
                inputTelNumber.setError("Telephone number is requied");
                return;
            }
            if (uaddress.isEmpty()){
                inputAddress.setError("Address is requied");
                return;
            }
            if (upassword.isEmpty()){
                inputPassword.setError("Password is requied");
                return;
            }

            auth.createUserWithEmailAndPassword(uemail, upassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
//                        Log.i("gogpo", "123 " + uemail + upassword);
                    Employee employee = new Employee(uname, upost, uiin, utelnum, uaddress, uemail, upassword, "", "", "");
                    emailformat = employee.getEmployeeEmail().replace(".", "-");
                    myRef.child("users").child("managers").child(emailformat).setValue(employee);
                    Intent i = new Intent(getApplicationContext(), ManagersActivity.class);
                    startActivity(i);
                    Toast.makeText(NewManagerActivity.this, "New employee succeddfully registered", Toast.LENGTH_SHORT).show();
//                        finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(NewManagerActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(NewManagerActivity.this, ManagersActivity.class));
        }else if (v.getId() == R.id.back){
            startActivity(new Intent(NewManagerActivity.this, ManagersActivity.class));
        }
    }
}