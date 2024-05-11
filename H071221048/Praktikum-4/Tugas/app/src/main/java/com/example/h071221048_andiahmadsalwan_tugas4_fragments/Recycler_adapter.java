package com.example.h071221048_andiahmadsalwan_tugas4_fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Recycle_model>recycle_model;
    public Recycler_adapter( Context context, ArrayList<Recycle_model>recycle_model,RecyclerViewInterface recyclerViewInterface){
        this.context=context;
        this.recycle_model=recycle_model;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public Recycler_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_recyclerview,parent,false);
        return new Recycler_adapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_adapter.MyViewHolder holder, int position) {
        holder.name.setText(recycle_model.get(position).getName());
        holder.desc.setText(recycle_model.get(position).getDesc());
        holder.fulldesc.setText(recycle_model.get(position).getFulldesc());
        holder.pf_image.setImageResource(recycle_model.get(position).getPf_image());
        holder.image.setImageURI(recycle_model.get(position).getNewimage());
    }

    @Override
    public int getItemCount() {
        return recycle_model.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView pf_image;
        TextView name,desc,fulldesc;
        Button delete;
        ImageView image;

        public  MyViewHolder(@NonNull View itemView ,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            pf_image=itemView.findViewById(R.id.recycle_image);
            name=itemView.findViewById(R.id.recycle_name);

            desc=itemView.findViewById(R.id.recycle_desc);
            fulldesc=itemView.findViewById(R.id.recycle_fulldesc);
            delete=itemView.findViewById(R.id.recycle_button);
            image=itemView.findViewById(R.id.recycle_fullimage);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.showFull(pos);
                        }
                    }
                }
            });
            desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.showFull(pos);
                        }
                    }
                }
            });
            pf_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.showFull(pos);
                        }
                    }
                }
            });
        }
    }
}
