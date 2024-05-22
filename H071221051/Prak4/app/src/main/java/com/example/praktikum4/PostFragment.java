package com.example.praktikum4;

import static com.example.praktikum4.DataSource.cats;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum4.Cat;
import com.example.praktikum4.CatAdapter;
import com.example.praktikum4.DataSource;
import com.example.praktikum4.R;

import java.util.ArrayList;

public class PostFragment extends Fragment {

    private Button btn_post;
    private EditText et_konten1;
    private ImageView iv_post1;
    private ActivityResultLauncher<Intent> launcherIntentGallery;
    private Uri selectedImageUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_post = view.findViewById(R.id.btn_post);
        et_konten1 = view.findViewById(R.id.et_konten1);
        iv_post1 = view.findViewById(R.id.iv_post1);

        iv_post1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(Intent.ACTION_PICK);
                open.setType("image/*");
                launcherIntentGallery.launch(open);
            }
        });


        // Inisialisasi launcherIntentGallery untuk handling hasil dari galeri
        launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            selectedImageUri = data.getData();
                            iv_post1.setImageURI(selectedImageUri);
                            iv_post1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    }
                });

        // Set OnClickListener for btn_post
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String konten = et_konten1.getText().toString();

                if (!konten.isEmpty() && selectedImageUri != null) {
                    Cat newCat = new Cat("Puss In Boots", "Puss", konten, R.drawable.kucing5, selectedImageUri);

                    cats.add(0, newCat);


                    et_konten1.setText("");
                    iv_post1.setImageResource(0);
                    selectedImageUri = null;

                    Toast.makeText(requireContext(), "Post added successfully", Toast.LENGTH_SHORT).show();

                    FragmentManager fragmentManager =getParentFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                } else {
                    Toast.makeText(requireContext(), "Please fill in content and select an image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
