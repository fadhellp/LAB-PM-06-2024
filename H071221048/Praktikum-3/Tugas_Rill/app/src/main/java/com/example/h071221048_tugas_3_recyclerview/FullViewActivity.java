package com.example.h071221048_tugas_3_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class FullViewActivity extends AppCompatActivity {
    ImageView iv_fullView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        int fullView=getIntent().getIntExtra("image",0);
        iv_fullView=findViewById(R.id.iv_fullView);
        iv_fullView.setImageResource(fullView);
    }
}