package com.example.praktikum7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        TextInputEditText regNimInput = findViewById(R.id.nim2);
        TextInputEditText regPassInput = findViewById(R.id.password2);
        Button buttonReg = findViewById(R.id.btnRegister);
        LinearLayout linearLayout = findViewById(R.id.mainRegister);
//memeriksa mode mlm,jka mode mlm di aktfkn tmpiln apk diubah sesuai tema gelap.jika tdk tema biasa di gnkn
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);

        SharedPreferences sharedPreferences1 = getSharedPreferences("MODE", MODE_PRIVATE);
        boolean nightMode = sharedPreferences1.getBoolean("darkMode", false);
        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            linearLayout.setBackgroundResource(R.drawable.bgdark);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            linearLayout.setBackgroundResource(R.drawable.bgwhite);
        }
//jika tombol pndftrn ditekan kode akan mngmbil nim dan pass
        buttonReg.setOnClickListener(v ->{
            String nim = regNimInput.getText().toString();
            String password = regPassInput.getText().toString();

            if (nim.isEmpty()) {
                regNimInput.setError("Please fill this field");
            } else if (password.isEmpty()) {
                regPassInput.setError("Please fill this field");
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nim", nim);
                editor.putString("password", password);
                editor.apply();
//pengguna akan di alihkan kembali ke hlm login(main act) stlh pnftn brhsil
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
// pesan sukses akn di tmpilkan di toast
                Toast.makeText(RegisterActivity.this, "Berhasil membuat akun.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}