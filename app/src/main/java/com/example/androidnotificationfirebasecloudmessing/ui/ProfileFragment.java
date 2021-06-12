package com.example.androidnotificationfirebasecloudmessing.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.androidnotificationfirebasecloudmessing.R;
import com.example.androidnotificationfirebasecloudmessing.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {


    private TextView email,name,topic;
    private Button logout;
    private CircleImageView image;
    private View view;
    private ProgressBar loader;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment
        email = view.findViewById(R.id.email);
        name = view.findViewById(R.id.name);
        image = view.findViewById(R.id.image);
        logout = view.findViewById(R.id.logout);
        loader = view.findViewById(R.id.progress_bar);
        topic = view.findViewById(R.id.topic);


        loader.setVisibility(View.VISIBLE);
        FirebaseDatabase.getInstance().getReference()
                .child("User").child(FirebaseAuth.getInstance().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        loader.setVisibility(View.GONE);
                        User user = dataSnapshot.getValue(User.class);

                        email.setText(user.getEmail());
                        name.setText(user.getName());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        loader.setVisibility(View.GONE);
                    }
                });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(),LoginActivity.class));
                getActivity().finish();
            }
        });


        return view;
    }
}