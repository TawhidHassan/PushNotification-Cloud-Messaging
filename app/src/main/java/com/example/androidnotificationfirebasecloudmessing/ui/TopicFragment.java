package com.example.androidnotificationfirebasecloudmessing.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidnotificationfirebasecloudmessing.R;
import com.example.androidnotificationfirebasecloudmessing.adapter.TopicAdapter;
import com.example.androidnotificationfirebasecloudmessing.model.Topic;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TopicFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private TopicAdapter adapter;


    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_topic, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTpoic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Topic> options =
                new FirebaseRecyclerOptions.Builder<Topic>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Topic"), Topic.class)
                        .build();


        adapter = new TopicAdapter(options);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}