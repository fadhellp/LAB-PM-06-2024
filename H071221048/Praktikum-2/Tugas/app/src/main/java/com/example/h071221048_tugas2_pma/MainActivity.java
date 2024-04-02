package com.example.h071221048_tugas2_pma;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String PARCEL_STD = "Parcel_Nama";
    Button submit;
    ImageView buttonGalery;
    ActivityResultLauncher<Intent> resultLauncher;
    EditText nama;
    EditText Nim;
    Uri uri;
    boolean cekGambar=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.submit);
        buttonGalery=findViewById(R.id.imgbutton);
        submit.setOnClickListener(View->nextPage());
        buttonGalery.setOnClickListener(View -> pickImage());
        nama=findViewById(R.id.Nama);
        Nim=findViewById(R.id.NIM);
        registerResult();
    }

    private void nextPage(){
        String text=nama.getText().toString();
        String text2=Nim.getText().toString();
        buttonGalery.setDrawingCacheEnabled(true);
        if (text.matches("")) {
            Toast.makeText(this, "UserName Kosong", Toast.LENGTH_SHORT).show();
            return;

        } else if (text2.matches("")) {
            Toast.makeText(this, "NIM Kosong", Toast.LENGTH_SHORT).show();
            return;
        } else if (cekGambar==false) {
            Toast.makeText(this, "Belum memilih gambar", Toast.LENGTH_SHORT).show();
            return;
        } else {
            passItem passItem = new passItem(text, text2);
            Intent note = new Intent(MainActivity.this, NoteActivity.class);
            note.putExtra("pass", passItem);
            note.putExtra("img", uri);
            startActivity(note);
        }
    }

    private void pickImage(){
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        resultLauncher.launch(intent);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&data!=null){
            uri=data.getData();
            buttonGalery.setImageURI(uri);
        }
    }

    private void registerResult(){
        resultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        try{
                            Intent data = result.getData();
                            if (data != null) {
                                Uri imageUri = data.getData();
                                buttonGalery.setImageURI(imageUri);
                                cekGambar=true;
                            } else {
                                Toast.makeText(MainActivity.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );

    }

}