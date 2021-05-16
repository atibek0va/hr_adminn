package com.example.hradmin.fragment;

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
import com.example.hradmin.adapter.ComplaintAdapter;
import com.example.hradmin.model.Complaint;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ComplaintFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    ArrayList<Complaint> complaintList;
    ComplaintAdapter complaintAdapter;
    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_complaint, container, false);
        recyclerView = view.findViewById(R.id.recycleComplaints);
        complaintList = new ArrayList<>();
        complaintAdapter = new ComplaintAdapter(getContext(), complaintList);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();
        myRef.child("complaints").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot complaints: snapshot.getChildren()) {
                        Complaint complaint = complaints.getValue(Complaint.class);
                        complaintList.add(complaint);
                    }
                    complaintAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(complaintAdapter);

        return view;
    }
}