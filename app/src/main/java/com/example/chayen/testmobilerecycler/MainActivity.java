package com.example.chayen.testmobilerecycler;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerAdapter myAdapter;
    private RecyclerView recyclerView;
    ArrayList<RecyclerAdapterClass> recycler_list = new ArrayList<>();
    RecyclerAdapterClass recyclerAdapterClass;

    int[] image_array = {
            R.drawable.logotwitter,
            R.drawable.mobile_icon,
            R.drawable.t_icon
    };

    String[] text_array = {
            "twitter",
            "mobile",
            "t icon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){
        recyclerView = (RecyclerView)findViewById(R.id.activity_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerView.setHasFixedSize(true);

        getData();
        myAdapter = new RecyclerAdapter(recycler_list);
        recyclerView.setAdapter(myAdapter);
    }

    private void getData(){
        for(int i = 0; i < text_array.length; i++){
            recyclerAdapterClass = new RecyclerAdapterClass();
            recyclerAdapterClass.setTextview(text_array[i]);
            recyclerAdapterClass.setImageview(image_array[i]);
            recycler_list.add(recyclerAdapterClass);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        ((RecyclerAdapter) myAdapter).setOnItemClickListener(new RecyclerAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(intent);
                ExamActivity.imageID = recycler_list.get(position).getImageview();
//                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
