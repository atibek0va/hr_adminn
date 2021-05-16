package com.example.hradmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hradmin.R;
import com.example.hradmin.model.Job;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.MyTViewHolder>{
    private Context context;
    private ArrayList<Job> jobList;

    public JobAdapter(Context context, ArrayList<Job> jobList) {
        this.context = context;
        this.jobList = jobList;
    }

    public JobAdapter(List<Job> jobList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public TextView jobName, jobSalary, jobTime;

        public MyTViewHolder(View view){
            super(view);
            jobName = view.findViewById(R.id.jobName);
            jobSalary = view.findViewById(R.id.jobSalary);
            jobTime = view.findViewById(R.id.jobTime);
        }
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false);
        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Job item = jobList.get(position);

//        Glide.with ( context.getApplicationContext () )
//                .load ( item.getPhoto () )
//                .placeholder ( R.drawable.doctor )
//                .into ( holder.doctor_photo );
        holder.jobName.setText(item.getJobName());
        holder.jobSalary.setText(item.getJobSalary());
        holder.jobTime.setText(item.getJobTime());

//        holder.btnZapis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String key = item.getKey();
//                Intent intent = new Intent(context, BronActivity.class);
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
}
