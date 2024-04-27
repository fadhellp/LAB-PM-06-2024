package com.example.h071221048_tugas_3_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity  {
    TextView tvName,tvLikes,tvDislikes,tv_likes,tv_dislikes,tv_post;
    ImageView iv_ppImage,iv_image;

    ArrayList<Upper> upper=new ArrayList<>();
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
        setContentView(R.layout.activity_account);
        setUpUpper();
        setUpLower();

        String name=getIntent().getStringExtra("name");
        int ppimage=getIntent().getIntExtra("ppimage",0);
        int image=getIntent().getIntExtra("images",0);
        int likes=getIntent().getIntExtra("likes",0);
        int dislikes=getIntent().getIntExtra("dislikes",0);
        int position=getIntent().getIntExtra("position",0);

        tvName=findViewById(R.id.tvName);
        iv_ppImage=findViewById(R.id.iv_ppImage);
        iv_image=findViewById(R.id.iv_post);
        tvLikes=findViewById(R.id.tvLikes);
        tvDislikes=findViewById(R.id.tvDislikes);
        tv_likes=findViewById(R.id.likes);
        tv_dislikes=findViewById(R.id.dislikes);
        tv_post=findViewById(R.id.post);

        tvName.setText(name);
        iv_ppImage.setImageResource(ppimage);
        iv_image.setImageResource(image);
        tvLikes.setText(String.valueOf(likes));
        tvDislikes.setText(String.valueOf(dislikes));
        tv_likes.setText("Likes");
        tv_dislikes.setText("Dislikes");
        tv_post.setText("Postingan");

        iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccountActivity.this,DetailActivity.class);
                intent.putExtra("DetailImage",lower.get(position).getImage());
                intent.putExtra("NAME",lower.get(position).getName());
                intent.putExtra("Image",lower.get(position).getPpimage());
                intent.putExtra("Desc",lower.get(position).getDesc());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        iv_ppImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccountActivity.this,FullViewActivity.class);
                intent.putExtra("image",lower.get(position).getImage());
                startActivity(intent);
            }
        });


    }
    private void setUpUpper(){

        String[] name=getResources().getStringArray(R.array.lvlName);
        String[] desc=getResources().getStringArray(R.array.lvlDesc);

        for (int i = 0; i < name.length; i++) {
            upper.add(new Upper(name[i],desc[i],detailImages[i],upperImages[i]));
        }
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