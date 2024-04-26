package com.example.h071221048_tugas_3_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpperAdapter extends RecyclerView.Adapter<UpperAdapter.MyViewHolder> {
    Context context;
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<Upper>upper;

    public  UpperAdapter(Context context, ArrayList<Upper> upper,
                         RecyclerViewInterface recyclerViewInterface){
        this.context=context;
        this.upper=upper;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public UpperAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.upper,parent,false);

        return new UpperAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull UpperAdapter.MyViewHolder holder, int position) {
        holder.name.setText(upper.get(position).getName());
        holder.image.setImageResource(upper.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return upper.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        public MyViewHolder(@NonNull View itemView,
                            RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            image=itemView.findViewById(R.id.iv_ppImage);
            name=itemView.findViewById(R.id.tv_lwrName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
