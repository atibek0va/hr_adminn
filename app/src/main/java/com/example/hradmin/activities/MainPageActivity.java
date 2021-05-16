package com.example.hradmin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.hradmin.R;
import com.example.hradmin.fragment.CoursesFragment;
import com.example.hradmin.fragment.FinanceFragment;
import com.example.hradmin.fragment.JobFragment;
import com.example.hradmin.fragment.QuestionFragment;
import com.example.hradmin.fragment.SpecialtyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPageActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initViews();
        onClicked();
    }

    public void initViews(){
        toolbar = findViewById(R.id.main_tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        notifications = findViewById(R.id.notification);

        BottomNavigationView btnNav = findViewById(R.id.bottom_nav);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, new SpecialtyFragment()).commit();
    }

    public void onClicked(){

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPageActivity.this, NotificationsActivity.class));
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.employees:
                    selectedFragment = new SpecialtyFragment();
                    break;
                case R.id.jobs:
                    selectedFragment = new JobFragment();
                    break;
                case R.id.finance:
                    selectedFragment = new FinanceFragment();
                    break;
                case R.id.courses:
                    selectedFragment = new CoursesFragment();
                    break;
                case R.id.faq:
                    selectedFragment = new QuestionFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_layout,
                            selectedFragment).commit();
            return true;
        }
    };

}