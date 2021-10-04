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

public class MainActivity extends AppCompatActivity {

    Button maps;

    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps = findViewById(R.id.button);
        icon = findViewById(R.id.imageView);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnOpenInGoogleMaps(view);
            }
        });

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnSetAvatarButton(view);
            }
        });

    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressTextView);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        ImageView avatarImage = (ImageView) findViewById(R.id.imageView);
                        String drawableName;
                        switch (data.getIntExtra("imageID", R.id.iconid00)){
                            case R.id.iconid00:
                                drawableName = "icon_00";
                                break;
                            case R.id.iconid01:
                                drawableName = "icon_01";
                                break;
                            case R.id.iconid02:
                                drawableName = "icon_02";
                                break;
                            case R.id.iconid03:
                                drawableName = "icon_03";
                                break;
                            case R.id.iconid04:
                                drawableName = "icon_04";
                                break;
                            case R.id.iconid05:
                                drawableName = "icon_05";
                                break;
                            case R.id.iconid06:
                                drawableName = "icon_06";
                                break;
                            case R.id.iconid07:
                                drawableName = "icon_07";
                                break;
                            case R.id.iconid08:
                                drawableName = "icon_08";
                                break;
                            default:
                                drawableName = "icon_empty";
                                break;
                        }
                        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                        avatarImage.setImageResource(resID);
                    }
                }
            }
    );

    public void OnSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }
}