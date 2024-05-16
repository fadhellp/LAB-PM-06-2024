package com.example.h071221048_andiahmadsalwan_tugas4_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Right extends Fragment {

   View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_right, container, false);
        String[] name= getResources().getStringArray(R.array.MyProfile);
        TextView profile_name=view.findViewById(R.id.profile_name);
        TextView profile_desc=view.findViewById(R.id.profile_desc);
        profile_name.setText(name[0]);
        profile_desc.setText(name[1]);
        return view;
    }
}