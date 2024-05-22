package com.example.praktikum4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    private TextView tv_nama, tv_username;
    private ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Cat cat = intent.getParcelableExtra("cat");

        tv_nama = findViewById(R.id.tv_nama2);
        tv_username = findViewById(R.id.tv_username2);
        iv_profile = findViewById(R.id.iv_profile2);

        iv_profile.setImageResource(cat.getProfile());
        tv_nama.setText(cat.getNama());
        tv_username.setText(cat.getUsername());
    }
}