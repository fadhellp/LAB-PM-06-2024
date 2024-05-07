package com.example.prak7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    Button btnLogout, btnSetting;
    TextView tvNim;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogout = findViewById(R.id.btn_logout);
        btnSetting = findViewById(R.id.btn_setting);
        tvNim = findViewById(R.id.tv_nim);

        sharedPreferences = getSharedPreferences("apa", MODE_PRIVATE);
        String nim = sharedPreferences.getString("nimRegis","");

        tvNim.setText("Selamat datang " + nim);

        btnLogout.setOnClickListener(v ->{
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("is_logged_in"); // Hapus status login juga
            editor.apply();

            // Alihkan pengguna kembali ke MainActivity
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnSetting.setOnClickListener(v -> {
            Intent intent = new Intent(this, Setting.class);
            startActivity(intent);
        });
    }
}