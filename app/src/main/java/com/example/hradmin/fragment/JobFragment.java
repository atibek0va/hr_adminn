package com.example.hradmin.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hradmin.R;
import com.example.hradmin.activities.EmployeesActivity;
import com.example.hradmin.activities.NewEmployeeActivity;
import com.example.hradmin.activities.NewJobActivity;
import com.example.hradmin.activities.WelcomeActivity;
import com.example.hradmin.adapter.JobAdapter;
import com.example.hradmin.model.Employee;
import com.example.hradmin.model.Job;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JobFragment extends Fragment {

    View view;

    FloatingActionButton btnFloat;

    RecyclerView recyclerView;
    ArrayList<Job> jobList;
    JobAdapter jobAdapter;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;

    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_job, container, false);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        btnFloat = view.findViewById(R.id.btnFloat);

        recyclerView = view.findViewById(R.id.recycleJobs);
        jobList = new ArrayList<>();
        jobAdapter = new JobAdapter(getContext(), jobList);

        myRef.child("jobs").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot jobs: snapshot.getChildren()) {
                        Job job = jobs.getValue(Job.class);
                        jobList.add(job);
                    }
                    jobAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(jobAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WelcomeActivity.class));
            }
        });

        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewJobActivity.class));
            }
        });

        return view;
    }
}