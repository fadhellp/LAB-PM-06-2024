package com.example.h071221048_andiahmadsalwan_tugas4_fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FullView extends AppCompatActivity {
    TextView tv_name,tv_decs;
    ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        tv_name=findViewById(R.id.tv_detailName);
        tv_decs=findViewById(R.id.tv_detailDecs);
        iv_image=findViewById(R.id.iv_detailImage);

    String name=getIntent().getStringExtra("name");
    int img=getIntent().getIntExtra("img",0);
    String decs=getIntent().getStringExtra("decs");

    tv_name.setText(name);
    tv_decs.setText(decs);
    iv_image.setImageResource(img);
    }
}