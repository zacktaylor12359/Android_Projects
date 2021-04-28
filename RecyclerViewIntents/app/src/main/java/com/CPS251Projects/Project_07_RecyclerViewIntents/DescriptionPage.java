package com.CPS251Projects.Project_07_RecyclerViewIntents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_page);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        int descriptImage = extras.getInt("imageResource");
        final ImageView imageView = findViewById(R.id.AndroidImage);
        imageView.setImageResource(descriptImage);


        String descriptTitle = extras.getString("descriptTitle");
        final TextView textView1 = findViewById(R.id.TitleText);
        textView1.setText(descriptTitle);

        String descriptDetail = extras.getString("descriptDetail");
        final TextView textView2 = findViewById(R.id.DetailText);
        textView2.setText(descriptDetail);
    }
}