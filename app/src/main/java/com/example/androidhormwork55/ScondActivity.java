package com.example.androidhormwork55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

public class ScondActivity extends AppCompatActivity {
    private TextView txtNameBook, txtDescriptionBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scond);
        txtNameBook = findViewById(R.id.txt_name_book);
        txtDescriptionBook = findViewById(R.id.txt_description_book);

        Bundle extras = getIntent() .getExtras();
        if (extras != null){
            String name = extras.getString("name");
            String description = extras.getString("description");
            txtNameBook.setText(name);
            txtDescriptionBook.setText(description);
        }
    }
}