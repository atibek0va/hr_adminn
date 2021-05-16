package com.example.hradmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hradmin.R;
import com.example.hradmin.model.Course;
//import com.example.hrapp.R;
//import com.example.hrapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.MyTViewHolder>{
    private Context context;
    private List<Course> courseList;

    public CoursesAdapter(List<Course> courseList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, courseUniver;

        public MyTViewHolder(View view){
            super(view);
            courseName = view.findViewById(R.id.courseName);
            courseUniver = view.findViewById(R.id.courseUniver);
        }
    }
    public CoursesAdapter(Context context, ArrayList<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_courses, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Course item = courseList.get(position);

        holder.courseName.setText(item.getCourseName());
        holder.courseUniver.setText(item.getCourseUniver());


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}
