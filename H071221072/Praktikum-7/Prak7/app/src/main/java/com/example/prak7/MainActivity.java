package com.example.prak7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNim, etPass;
    Button btLogin, btRegis;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNim = findViewById(R.id.et_nim);
        etPass = findViewById(R.id.et_pass);
        btLogin = findViewById(R.id.bt_login);
        btRegis = findViewById(R.id.bt_regis);

        sharedPreferences = getSharedPreferences("apa", MODE_PRIVATE);

        // Cek apakah pengguna sudah login sebelumnya
        if (sharedPreferences.getBoolean("is_logged_in", false)) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish(); // Selesai activity saat ini (MainActivity)
        }

        btRegis.setOnClickListener(v ->{
            Intent intent = new Intent(this, Registrasi.class);
            startActivity(intent);
        });

        btLogin.setOnClickListener(v ->{
            String nimRegis = sharedPreferences.getString("nimRegis", "");
            String passRegis = sharedPreferences.getString("passRegis", "");
            if (!etNim.getText().toString().isEmpty() && !etPass.getText().toString().isEmpty()) {
                if (etNim.getText().toString().equals(nimRegis) && etPass.getText().toString().equals(passRegis)) {
                    // Tandai pengguna sebagai sudah login
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("is_logged_in", true);
                    editor.apply();

                    Intent intent = new Intent(this, Login.class);
                    startActivity(intent);
                    finish(); // Selesai activity saat ini (MainActivity)
                }  else {
                    // Tampilkan notifikasi nim atau password salah
                    Toast.makeText(this, "NIM atau password salah. Silakan coba lagi.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Kolom tidak boleh kosong!!.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
