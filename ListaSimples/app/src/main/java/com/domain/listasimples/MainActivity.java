package com.domain.listasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    }
}