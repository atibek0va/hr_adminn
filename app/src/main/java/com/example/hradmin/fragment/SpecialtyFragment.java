package com.example.hradmin.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hradmin.R;
import com.example.hradmin.activities.EmployeesActivity;
import com.example.hradmin.activities.ManagersActivity;

public class SpecialtyFragment extends Fragment {

    CardView cv, cv1, cv2, cv3, cv4;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_specialty, container, false);

        cv = view.findViewById(R.id.cv);
        cv1 = view.findViewById(R.id.cv1);
        cv2 = view.findViewById(R.id.cv2);
        cv3 = view.findViewById(R.id.cv3);
        cv4 = view.findViewById(R.id.cv4);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EmployeesActivity.class));
            }
        });
//        cv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ManagersActivity.class));
//            }
//        });

        return view;
    }
}