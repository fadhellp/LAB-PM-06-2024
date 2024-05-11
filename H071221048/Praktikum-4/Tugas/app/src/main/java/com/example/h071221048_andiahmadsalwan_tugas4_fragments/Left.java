package com.example.h071221048_andiahmadsalwan_tugas4_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Left extends Fragment implements RecyclerViewInterface {

    ArrayList<Recycle_model> recycle_model=new ArrayList<>();
    Recycler_adapter adapter;
    Uri uri;
    View view;
    static List<Integer> pfimages=new ArrayList<>();
    static List<Uri> images=new ArrayList<>();
    static List<String> names=new ArrayList<String>();
    static List<String> descs=new ArrayList<String>();
    static List<String> descslong=new ArrayList<String>();
    static boolean firstleft=MainActivity.isFirstLeft();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (firstleft == true) {
            initializeList();
            setUpRecycle();
        } else if (firstleft!=true) {
            setUpRecycle();
        }
        view= inflater.inflate(R.layout.fragment_left, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.home_recyclerview);

        adapter=new Recycler_adapter( requireContext(),recycle_model,this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        getParentFragmentManager().setFragmentResultListener("datafromMid",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String data=result.getString("des");
                        String picture= result.getString("img");
                        names.add("Tanjiro Kamado");
                        descs.add("Water Breathing...");
                        descslong.add(data);
                        pfimages.add(R.drawable.myprofile);
                        Toast.makeText(requireContext(), picture, Toast.LENGTH_SHORT).show();
                        uri=Uri.parse(picture);
                        images.add(uri);
                        recycle_model.clear();
                        setUpRecycle();


                    }
                });

        return view;
    }
    public void setUpRecycle(){
        recycle_model.clear();
        if (names.size()==images.size()) {

            for (int i = 0; i < names.size(); i++) {
                recycle_model.add(new Recycle_model(
                        pfimages.get(i),
                        images.get(i),
                        names.get(i),
                        descs.get(i),
                        descslong.get(i)));
            }
        }else {

            for (int i = 0; i < images.size(); i++) {
                recycle_model.add(new Recycle_model(pfimages.get(i), images.get(i), names.get(i),
                        descs.get(i), descslong.get(i)));
            }
            int lastImageIndex=pfimages.size()-1;
            int lastIndex=names.size()-1;
                recycle_model.add(new Recycle_model(pfimages.get(lastImageIndex),uri,names.get(lastIndex),
                        descs.get(lastIndex), descslong.get(lastIndex)));
            Collections.reverse(recycle_model);

        }
    }

    public void initializeList(){
        MainActivity.setFirstLeft(false);
        firstleft=false;
        String[] name=getResources().getStringArray(R.array.profileName);
        String[] desc=getResources().getStringArray(R.array.profileDesc);
        String[] desclong=getResources().getStringArray(R.array.profileLongDesc);

        String[] str = {
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas4_fragments/" + R.drawable.caelus,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas4_fragments/" + R.drawable.furina,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas4_fragments/" + R.drawable.lucia,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas4_fragments/" + R.drawable.robin,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas4_fragments/" + R.drawable.vice
        };

        Uri[] image = new Uri[str.length];
        for (int i = 0; i < str.length; i++) {
            image[i] = Uri.parse(str[i]);
        }
        int[] pfimage={R.drawable.caelus,R.drawable.furina,R.drawable.lucia,R.drawable.robin,R.drawable.vice,R.drawable.myprofile};
        for (String nama:name){
            names.add(nama);
        }
        for (String descript:desc){
            descs.add(descript);
        }
        for (String descriptlong:desclong){
            descslong.add(descriptlong);
        }
        for(Integer pimages:pfimage){
            pfimages.add(pimages);
        }
        for(Uri gambar:image){
            images.add(gambar);
        }
    }

    @Override
    public void onItemClick(int position) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(requireContext());
        alertDialog.setMessage("Delete this item?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recycle_model.remove(position);
                        names.remove(position);
                        images.remove(position);
                        descs.remove(position);
                        descslong.remove(position);
                        pfimages.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
        AlertDialog dialog=alertDialog.create();
        dialog.show();

    }

    @Override
    public void showFull(int position) {
        Intent intent = new Intent(requireContext(),FullView.class);
        intent.putExtra("name",recycle_model.get(position).getName());
        intent.putExtra("img", recycle_model.get(position).getPf_image());
        intent.putExtra("desc",recycle_model.get(position).getDesc());
        startActivity(intent);
    }

}