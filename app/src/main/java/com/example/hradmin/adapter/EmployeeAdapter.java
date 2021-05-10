package com.example.hradmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hradmin.R;
import com.example.hradmin.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyTViewHolder>{
    private Context context;
    private ArrayList<Employee> employeesList;

    public EmployeeAdapter(Context context, ArrayList<Employee> employeesList) {
        this.context = context;
        this.employeesList = employeesList;
    }

    public EmployeeAdapter(List<Employee> employeesList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public TextView employeeName, employeeSpecial, employeeIIN, employeeNumber, employeeAddress, employeeEmail, employeePassword;

        public MyTViewHolder(View view){
            super(view);
            employeeName = view.findViewById(R.id.employeeName);
            employeeSpecial = view.findViewById(R.id.employeeSpecial);
            employeeIIN = view.findViewById(R.id.employeeIIN);
            employeeNumber = view.findViewById(R.id.employeeNumber);
            employeeAddress = view.findViewById(R.id.employeeAddress);
            employeeEmail = view.findViewById(R.id.employeeEmail);
            employeePassword = view.findViewById(R.id.employeePassword);
        }
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Employee item = employeesList.get(position);

//        Glide.with ( context.getApplicationContext () )
//                .load ( item.getPhoto () )
//                .placeholder ( R.drawable.doctor )
//                .into ( holder.doctor_photo );
        holder.employeeName.setText(item.getEmployeeName());
        holder.employeeSpecial.setText(item.getEmployeeSpecial());
        holder.employeeIIN.setText(item.getEmployeeIIN());
        holder.employeeNumber.setText(item.getEmployeeNumber());
        holder.employeeAddress.setText(item.getEmployeeAddress());
        holder.employeeEmail.setText(item.getEmployeeEmail());
        holder.employeePassword.setText(item.getEmployeePassword());

//        holder.btnZapis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String key = item.getKey();
//                Intent intent = new Intent(context, BronActivity.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }
}
