package com.example.h071221048_andiahmadsalwan_tugas4_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.h071221048_andiahmadsalwan_tugas4_fragments.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    Button buttonmid,btnleft,btnright;

    public  static boolean firstLeft=true;

    public static boolean isFirstLeft() {
        return firstLeft;
    }

    public static void setFirstLeft(boolean firstLeft) {
        MainActivity.firstLeft = firstLeft;
    }

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Left());
        binding.bottomnavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.buttonleft) {
                replaceFragment(new Left());
            } else if (item.getItemId() == R.id.buttonmid) {
                replaceFragment(new Mid());
            } else if (item.getItemId() == R.id.buttonright) {
                replaceFragment(new Right());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void showFull(int position) {

    }
}