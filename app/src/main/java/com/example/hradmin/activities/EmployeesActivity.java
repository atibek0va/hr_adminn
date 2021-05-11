package com.example.hradmin.activities;

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

import java.util.ArrayList;

public class EmployeesActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    ArrayList<Employee> employeeList;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        initViews();
        getEmployees();
    }

    public void initViews(){
        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycleEmployee);
        employeeList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(this, employeeList);
        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    public void getEmployees(){
        employeeList.add(new Employee("Ms.Azaliya", "HR Director", "920063235265", "+7 708 419 54 22", "10/41/38", "azimkh@gmail.com", "12345678a"));
        employeeList.add(new Employee("Mr.Madibee", "HR Director", "910613298565", "+7 700 689 05 52", "Tole bi 52/2", "madiii@gmail.com", "qwerty123"));
        employeeList.add(new Employee("Ms.Azaliya", "HR Director", "920063235265", "+7 708 419 54 22", "10/41/38", "azimkh@gmail.com", "12345678a"));
        employeeList.add(new Employee("Mr.Madibee", "HR Director", "910613298565", "+7 700 689 05 52", "Tole bi 52/2", "madiii@gmail.com", "qwerty123"));
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back){
            startActivity(new Intent(EmployeesActivity.this, MainPageActivity.class));
        }
    }
}