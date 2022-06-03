package com.domain.listasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> androidVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidVersion = new ArrayList();
        androidVersion.add("Android 4 Ice Cream Sandwich");
        androidVersion.add("Android 4.1 Jelly Bean");
        androidVersion.add("Android 4.4 KitKat");
        androidVersion.add("Android 5 Lollipop");
        androidVersion.add("Android 6 Marshmallow");
        androidVersion.add("Android 7 Nougat");
        androidVersion.add("Android 8 Oreo");
        androidVersion.add("Android 9.0 Pie");
        androidVersion.add("Android 10 Q");
        androidVersion.add("Android 30");

        ListView lvAndroidVersion = findViewById(R.id.lvAndroidVersion);

        ArrayAdapter<String> adapterVersion = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, androidVersion);
        lvAndroidVersion.setAdapter(adapterVersion);

        lvAndroidVersion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String versionName = androidVersion.get(i);

                Toast.makeText(getApplicationContext(), "Item clicado posição: " + i + " " + versionName, Toast.LENGTH_LONG).show();
            }
        });

    }
}