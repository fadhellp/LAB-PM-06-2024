package com.example.h071221048_tugas2_pma;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    public static final String PARCEL_STD = "Parcel_Nama";

    ImageView image;
    Button button;
    EditText Title, Content;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        image = findViewById(R.id.gambar);
        Title = findViewById(R.id.Title);
        Content = findViewById(R.id.Content);
        button = findViewById(R.id.submit);
        button.setOnClickListener(View -> next());

    }

    private void next() {
        String title = Title.getText().toString();
        String content = Content.getText().toString();
        if (title.matches("")) {
            Toast.makeText(this, "Title Kosong", Toast.LENGTH_SHORT).show();
            return;
        } else if (content.matches("")) {
            Toast.makeText(this, "Content Kosong", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Title titles = new Title(title, content);
            Intent intent = getIntent();
            passItem note = intent.getParcelableExtra("pass");
            Uri uri = (Uri) intent.getParcelableExtra("img");
            Intent intent2 = new Intent(NoteActivity.this, ResultActivity.class);
            intent2.putExtra("title", titles);
            intent2.putExtra("pass", note);
            intent2.putExtra("img", uri);
            startActivity(intent2);
    }
}


}