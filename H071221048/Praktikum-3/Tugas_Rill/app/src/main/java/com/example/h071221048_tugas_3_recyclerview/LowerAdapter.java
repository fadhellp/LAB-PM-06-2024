package com.example.h071221048_tugas_3_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LowerAdapter extends RecyclerView.Adapter<LowerAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<Lower> lower;

    public  LowerAdapter(Context context, ArrayList<Lower>lower
    ,RecyclerViewInterface recyclerViewInterface){
        this.context=context;
        this.lower=lower;
        this.recyclerViewInterface=recyclerViewInterface;
    }
    @NonNull
    @Override
    public LowerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.lower,parent,false);
        return new LowerAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull LowerAdapter.MyViewHolder holder, int position) {
        holder.name.setText(lower.get(position).getName());
        holder.desc.setText(lower.get(position).getDesc());
        holder.image.setImageResource(lower.get(position).getImage());
        holder.ppImage.setImageResource(lower.get(position).getPpimage());
    }

    @Override
    public int getItemCount() {
        return  lower.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder {
        ImageView image,ppImage;
        TextView name,desc;

        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface
                            recyclerViewInterface) {
            super(itemView);

            name=itemView.findViewById(R.id.tv_lwrName);
            desc=itemView.findViewById(R.id.tv_lwrdesc);
            ppImage=itemView.findViewById(R.id.iv_ppImage);
            image=itemView.findViewById(R.id.iv_main);

            ppImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface!=null){
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
                    if(recyclerViewInterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick2(pos);
                        }
                    }
                }
            });
        }
    }


}
