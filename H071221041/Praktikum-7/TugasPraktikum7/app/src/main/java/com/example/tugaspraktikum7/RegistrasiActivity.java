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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrasiActivity extends AppCompatActivity {
    EditText etNim, etPassword;
    Button btnRegister;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);

        etNim = findViewById(R.id.etNimRegist);
        etPassword = findViewById(R.id.etPasswordRegist);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = etNim.getText().toString();
                String password = etPassword.getText().toString();

                if (nim.isEmpty()) {
                    etNim.setError("Masukkan NIM Terlebih Dahulu");
                    return;
                }
                if (password.isEmpty()) {
                    etPassword.setError("Masukkan Password Terlebih Dahulu");
                    return;
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NIM", nim);
                editor.putString("Password", password);
                editor.apply();

                Toast.makeText(RegistrasiActivity.this, "Berhasil Registrasi", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistrasiActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}