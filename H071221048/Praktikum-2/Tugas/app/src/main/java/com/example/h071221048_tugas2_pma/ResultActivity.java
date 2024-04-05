package com.example.h071221048_tugas2_pma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    public static final String PARCEL_STD = "Parcel_Nama";
    TextView Name;
    TextView Nim;
    TextView Content;
    TextView Title;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Name= findViewById(R.id.Nama);
         Nim= findViewById(R.id.NIM);
         Content=findViewById(R.id.Content);
         Title=findViewById(R.id.Title);
         picture=findViewById(R.id.picture);

        Intent intent=getIntent();
        Title titles=intent.getParcelableExtra("title");
        passItem note=intent.getParcelableExtra("pass");
        Uri uri=(Uri) intent.getParcelableExtra("img");

        picture.setImageURI(uri);
        Name.setText(note.getNama());
        Nim.setText(note.getNim());
        Title.setText(titles.getTitle());
        Content.setText(titles.getContent());

    }
}