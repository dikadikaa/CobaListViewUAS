package com.example.cobalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = (ListView) findViewById(R.id.lvNama);

        //String[] nama = {"eko","adi","surya","rina","dewi"};

        //ArrayList<String> daftar_nama = new ArrayList<>();

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        //daftar_nama.add("dani");
        //daftar_nama.add("doni");
        //daftar_nama.add("dika");

        if(daftar_nama.isEmpty()){
            daftar_nama.add("data masih kosong");
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);
    }
}