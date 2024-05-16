package com.example.praktikum7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
// mengatur tmpilan xml dngn mnggunakan setcontentview kemuadian toolbar diinisialisasi dan diatur action bar
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView tvHome = findViewById(R.id.tvHome);
        TextView tvHome1 = findViewById(R.id.tvHome1);
        setSupportActionBar(toolbar);
// memeriksa status mode mlm dari share dan mengaktifkan jika perlu dngn mnggunakan appcompat,wrn teks juga diatur sesuai mode mlm
        SharedPreferences sharedPreferences1 = getSharedPreferences("MODE", MODE_PRIVATE);
        boolean nightMode = sharedPreferences1.getBoolean("darkMode", false);
        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            tvHome.setTextColor(getResources().getColor(android.R.color.white));
            tvHome1.setTextColor(getResources().getColor(android.R.color.white));
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        tvHome.setText(sharedPreferences.getString("nim",""));
    }
//menginflasi menu toolbar dari file toolbar_menu.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
// jika item seeting dipilih akan menampilkan activity temaactivity
// dan jika item logout dipilih akan menonaktifkan sesi login dan kmbli ke activity mainactivity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.setting){
            Intent intent = new Intent(HomeActivity.this, TemaActivity.class);
            startActivity(intent);
        }
        if (id == R.id.logout){
            SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}