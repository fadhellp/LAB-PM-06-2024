package com.example.h071221048_tugas_3_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    LinearLayoutManager HorizontalLayout;

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
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.myUpper);
        RecyclerView recyclerView1=findViewById(R.id.myLower);
        setUpUpper();
        setUpLower();
        UpperAdapter adapter=new UpperAdapter(this,upper,this);
        recyclerView.setAdapter(adapter);
        LowerAdapter adapter1=new LowerAdapter(this,lower,this);
        recyclerView1.setAdapter(adapter1);
        HorizontalLayout=new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


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

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(MainActivity.this,DetailActivity.class);

        intent.putExtra("NAME",upper.get(position).getName());
        intent.putExtra("Position",position);
        intent.putExtra("Desc",upper.get(position).getDesc());
        intent.putExtra("DetailImage",upper.get(position).getDetailImage());
        intent.putExtra("Image",upper.get(position).getImage());
        startActivity(intent);
    }

    @Override
    public void onItemClick2(int position) {
        Intent intent = new Intent(MainActivity.this,AccountActivity.class);
        intent.putExtra("position",position);
        intent.putExtra("name",lower.get(position).getName());
        intent.putExtra("ppimage",lower.get(position).getPpimage());
        intent.putExtra("images",lower.get(position).getImage());
        intent.putExtra("likes",lower.get(position).getLikes());
        intent.putExtra("dislikes",lower.get(position).getDislikes());

        startActivity(intent);
    }
}