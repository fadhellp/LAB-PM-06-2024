package com.example.prak7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrasi extends AppCompatActivity {

    EditText etPass, etNim;
    Button btnSave;
    TextView tvnim, tvpass;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        etPass = findViewById(R.id.et_passRegis);
        etNim = findViewById(R.id.et_nimRegis);
        btnSave = findViewById(R.id.bt_saveRegis);
        tvnim = findViewById(R.id.tv_nim);
        tvpass = findViewById(R.id.tv_pass);

        sharedPreferences = getSharedPreferences("apa", MODE_PRIVATE);

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nimRegis", etNim.getText().toString());
            editor.putString("passRegis", etPass.getText().toString());
            editor.apply();
            Intent intent = new Intent(this,MainActivity.class);
            Toast.makeText(this, "Akun Berhasil dibuat", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}