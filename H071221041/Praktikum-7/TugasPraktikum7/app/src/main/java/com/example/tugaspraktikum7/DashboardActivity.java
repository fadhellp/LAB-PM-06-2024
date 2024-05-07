package com.example.tugaspraktikum7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {
    TextView tvWelcome;
    Button btnLogout, btnSetting;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnLogout = findViewById(R.id.btnLogout);
        btnSetting = findViewById(R.id.btnSetting);

        String nim = sharedPreferences.getString("NIM", "");
        tvWelcome.setText("Selamat datang " + nim);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
                finish();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, SettingActivity.class));
                finish();
            }
        });
    }
}