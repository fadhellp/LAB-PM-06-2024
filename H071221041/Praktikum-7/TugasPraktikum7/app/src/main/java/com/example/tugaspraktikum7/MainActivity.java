package com.example.tugaspraktikum7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etNim, etPassword;
    Button btnLogin, btnRegist;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);

        int theme = sharedPreferences.getInt("theme", 0);
        if (theme == 1) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }

        etNim = findViewById(R.id.etNim);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLoginAwal);
        btnRegist = findViewById(R.id.btnRegisterAwal);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = etNim.getText().toString();
                String password = etPassword.getText().toString();

                if (nim.isEmpty()) {
                    etNim.setError("NIM tidak boleh kosong");
                    return;
                }

                if (password.isEmpty()) {
                    etPassword.setError("Password tidak boleh kosong");
                    return;
                }

                String savedNIM = sharedPreferences.getString("NIM", "");
                String savedPassword = sharedPreferences.getString("Password", "");

                if (nim.equals(savedNIM) && password.equals(savedPassword)) {
                    Toast.makeText(MainActivity.this, "Selamat datang " + nim, Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "NIM atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrasiActivity.class));
            }
        });
    }
}