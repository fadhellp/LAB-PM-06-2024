package com.example.h071221048_andiahmadsalwan_tugas01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>textList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox game = findViewById(R.id.game);
        Button submit = findViewById(R.id.submit);
        EditText editText = findViewById(R.id.text);
        textList=new ArrayList<>();
        listView= findViewById(R.id.viewList);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>
                (this,R.layout.listview,R.id.textView,textList);
        listView.setAdapter(arrayAdapter);
        RadioButton radioButton1 = findViewById(R.id.man);
        RadioButton radioButton2 = findViewById(R.id.woman);


        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((RadioButton) v).isChecked()) {
                    ((RadioButton) v).setChecked(true);
                }
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((RadioButton) v).isChecked()) {
                    ((RadioButton) v).setChecked(true);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=editText.getText().toString();
                textList.add(inputText);
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }
}






