package com.example.l20;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.Serializable;

public class SecondActiity extends AppCompatActivity {

    ImageView in_image_gallery;
    EditText trans_data;
    private Button btn_trans_data_to_main_activity;
    String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_actiity);
        initView();
        listener();
    }

    private void initView() {
        in_image_gallery = findViewById(R.id.in_image_gallery);
        trans_data = findViewById(R.id.trans_data);
        btn_trans_data_to_main_activity = findViewById(R.id.btn_trans_data_to_main_activity);

    }

    private void listener() {
        in_image_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE);
                startActivity(intent);
                resultLauncher.launch("image/*");
            }
        });

        btn_trans_data_to_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = trans_data.getText().toString();
                Intent intent = new Intent(SecondActiity.this, MainActivity.class);
                intent.putExtra("Key", data);
                intent.putExtra( "image" , image);
                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri Uri) {
                    image = Uri.toString();
                    in_image_gallery.setImageURI(Uri);
                }
            });
}

