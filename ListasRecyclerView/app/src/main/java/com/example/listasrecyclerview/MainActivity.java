package com.example.listasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList androidVersion = new ArrayList();
        androidVersion.add("Android 4 Ice Cream Sandwich");
        androidVersion.add("Android 4.1 Jelly Bean");
        androidVersion.add("Android 4.4 KitKat");
        androidVersion.add("Android 5 Lollipop");
        androidVersion.add("Android 6 Marshmallow");
        androidVersion.add("Android 7 Nougat");
        androidVersion.add("Android 8 Oreo");
        androidVersion.add("Android 9.0 Pie");
        androidVersion.add("Android 10 Q");

        String[] colors = getResources().getStringArray(R.array.colors);

        AndroidVersionAdapter adapter = new AndroidVersionAdapter(androidVersion, colors);


        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        RecyclerView rv = findViewById(R.id.rvListaDeVersoes);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

    }
}