package com.example.prak7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Setting extends AppCompatActivity {

    Switch swtch;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        swtch = findViewById(R.id.switch_darkmode);
        sharedPreferences = getSharedPreferences("darkMode", MODE_PRIVATE);

        // Atur status switch sesuai dengan preferensi yang tersimpan
        swtch.setChecked(sharedPreferences.getBoolean("darkMode", false));

        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    // Simpan preferensi dark mode yang dipilih pengguna
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("darkMode", true);
                    editor.apply();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    // Simpan preferensi dark mode yang dipilih pengguna
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("darkMode", false);
                    editor.apply();
                }
            }
        });
    }
}
