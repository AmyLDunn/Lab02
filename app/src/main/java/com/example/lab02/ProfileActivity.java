package com.example.lab02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    //Icons
    ImageView i0, i1, i2, i3, i4, i5, i6, i7, i8;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Setting names for each of the 9 available icons
        i0 = findViewById(R.id.iconid00);
        i1 = findViewById(R.id.iconid01);
        i2 = findViewById(R.id.iconid02);
        i3 = findViewById(R.id.iconid03);
        i4 = findViewById(R.id.iconid04);
        i5 = findViewById(R.id.iconid05);
        i6 = findViewById(R.id.iconid06);
        i7 = findViewById(R.id.iconid07);
        i8 = findViewById(R.id.iconid08);

    }

    public void SetTeamIcon(View view) {

        // Creating a return Intent to pass to the Main Activity
        Intent returnIntent = new Intent();

        //Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;

        //Adding details to the return intent
        returnIntent.putExtra("imageID",selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        //Finishing the activity and returning to the main stream
        finish();

    }
}