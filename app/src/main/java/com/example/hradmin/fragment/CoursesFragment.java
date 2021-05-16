package com.example.hradmin.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hradmin.R;
import com.example.hradmin.activities.AllCoursesActivity;
import com.example.hradmin.activities.WelcomeActivity;

public class CoursesFragment extends Fragment {

    View view;
    Button allCourses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_courses, container, false);

        allCourses = view.findViewById(R.id.allCourses);

        allCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllCoursesActivity.class));
            }
        });

        return view;
    }
}