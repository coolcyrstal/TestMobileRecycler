package com.example.chayen.testmobilerecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ExamActivity extends AppCompatActivity {

    ImageView examimage;
    static int imageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        examimage = (ImageView)findViewById(R.id.exampleimage);
        Picasso.with(getApplicationContext()).load(imageID).into(examimage);
    }
}
