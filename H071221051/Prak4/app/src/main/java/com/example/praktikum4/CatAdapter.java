package com.example.praktikum4;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private ArrayList<Cat> cats;
    private Context context;
    public CatAdapter(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new CatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cat cat = cats.get(position);
        holder.tv_nama.setText(cat.getNama());
        holder.tv_username.setText(cat.getUsername());
        holder.tv_konten.setText(cat.getKonten());
        holder.iv_profile.setImageResource(cat.getProfile());
        if (cat.getPost() != null ) {
            holder.iv_post.setImageResource(cat.getPost());
        }
        if (cat.getSelectedImage() != null) {
            holder.iv_post.setImageURI(cat.getSelectedImage());
        }

        holder.tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("cat", cat);
                holder.context.startActivity(intent);
            }
        });

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("cat", cat);
                holder.context.startActivity(intent);
            }
        });

        // Menambahkan OnClickListener untuk tombol delete
        holder.iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Munculkan dialog konfirmasi sebelum menghapus
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext(), R.style.CustomAlertDialogStyle);
                builder.setTitle("Konfirmasi");
                builder.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Hapus item dari ArrayList berdasarkan posisi
                        cats.remove(position);

                        // Memberitahu adapter bahwa item telah dihapus
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, cats.size());
                        Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Tidak melakukan apa-apa jika pengguna memilih tidak
                        dialog.dismiss(); // Tutup dialog
                    }
                });

                // Munculkan dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return cats.size();
    }

    public void setData(ArrayList<Cat> cats) {
        this.cats = cats;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_username, tv_konten;
        ImageView iv_profile, iv_post, iv_delete;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_konten = itemView.findViewById(R.id.tv_konten);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            iv_post = itemView.findViewById(R.id.iv_post);
            iv_delete = itemView.findViewById(R.id.iv_delete);
            context = itemView.getContext();
        }
    }
}
