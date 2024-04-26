package com.example.h071221048_tugas_3_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView tv_name,tv_desc;
    ImageView detail,ppImage;

    ArrayList<Lower> lower=new ArrayList<>();
    int[] upperImages={R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,
            R.drawable.icon4,R.drawable.icon5,
            R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,
            R.drawable.icon4,R.drawable.icon5};
    int[] detailImages={R.drawable.tidalwave,R.drawable.avernus,
            R.drawable.acheron,R.drawable.silentclubstep,R.drawable.abyssofdarkness,
            R.drawable.kyouki,R.drawable.slaughterhouse,R.drawable.sakupencircles,
            R.drawable.tunnelofdespair,R.drawable.kocmoc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setUpLower();

        String name=getIntent().getStringExtra("NAME");
        String desc=getIntent().getStringExtra("Desc");
        int detailImage=getIntent().getIntExtra("DetailImage",0);
        int Image=getIntent().getIntExtra("Image",0);
        int position=getIntent().getIntExtra("posiiton",0);

        tv_name=findViewById(R.id.tv_name);
        detail=findViewById(R.id.iv_detail);
        ppImage=findViewById(R.id.iv_ppImage);
        tv_desc=findViewById(R.id.tv_desc);


        tv_name.setText(name);
        tv_desc.setText(desc);
        detail.setImageResource(detailImage);
        ppImage.setImageResource(Image);

        ppImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailActivity.this,AccountActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("name",lower.get(position).getName());
                intent.putExtra("ppimage",lower.get(position).getPpimage());
                intent.putExtra("images",lower.get(position).getImage());
                intent.putExtra("likes",lower.get(position).getLikes());
                intent.putExtra("dislikes",lower.get(position).getDislikes());
                startActivity(intent);
            }
        });
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailActivity.this,FullViewActivity.class);
                intent.putExtra("image",lower.get(position).getImage());
                startActivity(intent);
            }
        });

    }
    private void setUpLower(){
        String[] name=getResources().getStringArray(R.array.lvlName);
        String[] desc=getResources().getStringArray(R.array.lvlDesc);
        int[] likes=getResources().getIntArray(R.array.likes);
        int[] dislikes=getResources().getIntArray(R.array.dislikes);
        for (int i=0;i< name.length;i++){
            lower.add(new Lower(name[i],desc[i],
                    upperImages[i],
                    detailImages[i],likes[i]
                    ,dislikes[i]));
        }
    }


}