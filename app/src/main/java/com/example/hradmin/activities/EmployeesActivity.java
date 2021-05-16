package com.example.hradmin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hradmin.R;
import com.example.hradmin.adapter.EmployeeAdapter;
import com.example.hradmin.fragment.SpecialtyFragment;
import com.example.hradmin.model.Employee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EmployeesActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    FloatingActionButton btnFloat;
    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    ArrayList<Employee> employeeList;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        initViews();
//        getEmployees();
    }

    public void initViews(){
        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnBack = findViewById(R.id.back);
        btnFloat = findViewById(R.id.btnFloat);

        btnBack.setOnClickListener(this);
        btnFloat.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.recycleEmployee);
        employeeList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(this, employeeList);
        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot employees: snapshot.getChildren()) {
                        Employee employee = employees.getValue(Employee.class);
                        employeeList.add(employee);
                    }
                    employeeAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

//    public void getEmployees(){
//        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    for(DataSnapshot employees: snapshot.getChildren()) {
//                        Employee employee = employees.getValue(Employee.class);
//                        employeeList.add(employee);
//                    }
//                    employeeAdapter.notifyDataSetChanged();
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        employeeList.add(new Employee("Ms.Azaliya", "HR Director", "920063235265", "+7 708 419 54 22", "10/41/38", "azimkh@gmail.com", "12345678a"));
//        employeeList.add(new Employee("Mr.Madibee", "HR Director", "910613298565", "+7 700 689 05 52", "Tole bi 52/2", "madiii@gmail.com", "qwerty123"));
//        employeeList.add(new Employee("Ms.Azaliya", "HR Director", "920063235265", "+7 708 419 54 22", "10/41/38", "azimkh@gmail.com", "12345678a"));
//        employeeList.add(new Employee("Mr.Madibee", "HR Director", "910613298565", "+7 700 689 05 52", "Tole bi 52/2", "madiii@gmail.com", "qwerty123"));
//        employeeAdapter.notifyDataSetChanged();
//    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back){
            startActivity(new Intent(EmployeesActivity.this, MainPageActivity.class));
        }else if (v.getId() == R.id.btnFloat){
            startActivity(new Intent(EmployeesActivity.this, NewEmployeeActivity.class));
        }
    }
}