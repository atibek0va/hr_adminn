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
import com.example.hradmin.activities.RespondActivity;
import com.example.hradmin.adapter.QuestionAdapter;
import com.example.hradmin.adapter.RecyclerItemClickListener;
import com.example.hradmin.model.Question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WorkFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<Question> questionList;
    QuestionAdapter questionAdapter;
    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_work, container, false);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        recyclerView = view.findViewById(R.id.recycleQuestions);
        questionList = new ArrayList<>();
        questionAdapter = new QuestionAdapter(getContext(), questionList);

//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
        myRef.child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot questions: snapshot.getChildren()) {
                        Question question = questions.getValue(Question.class);
                        questionList.add(question);
                    }
                    questionAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(questionAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, final int pos) {
                                Intent intent = new Intent(getActivity(), RespondActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int pos) {

                            }
                        })
        );

        return view;
    }
}