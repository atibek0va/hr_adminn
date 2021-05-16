package com.example.hradmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hradmin.R;
import com.example.hradmin.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyTViewHolder>{
    private Context context;
    private ArrayList<Question> questionList;

    public QuestionAdapter(Context context, ArrayList<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    public QuestionAdapter(List<Question> questionList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public TextView question, questionDate, emaill;

        public MyTViewHolder(View view){
            super(view);
            emaill = view.findViewById(R.id.emaill);
            question = view.findViewById(R.id.question);
            questionDate = view.findViewById(R.id.questionDate);
        }
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Question item = questionList.get(position);

        holder.emaill.setText(item.getEmail());
        holder.question.setText(item.getQuestion());
        holder.questionDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
