package com.example.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private SeekBar seek;
    private String[] names = new String[]{"Tom", "Bob", "Alex", "Ted"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list();
    }

    public void list() {
        list = findViewById(R.id.listView);
        seek = findViewById(R.id.seekBar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.names, names);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = (String) list.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Значення: " + val + ", прогрес - " + seek.getProgress(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
