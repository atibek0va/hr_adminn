package com.example.hradmin.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hradmin.R;
import com.example.hradmin.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class QuestionFragment extends Fragment {

    View view;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    private void setUpViewPager(ViewPager viewPager) {
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new WorkFragment(), "Work/company");
        tabAdapter.addFragment(new ComplaintFragment(), "Complaint box");

        viewPager.setAdapter(tabAdapter);
    }
}