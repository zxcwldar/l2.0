package com.example.l20;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button btnOpenSecondActivity;
    TextView meaning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        btnOpenSecondActivity = findViewById(R.id.btn_open_second_acnivity);
        meaning = findViewById(R.id.meaning);



        meaning.setText("GEEKTECH");

        btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActiity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String getData = intent.getStringExtra( "Key");
        String imageS = intent.getStringExtra( "image");
        if ( imageS != null){
            meaning.setText(getData);
            image.setImageURI(Uri.parse(imageS));
        }



    }




}