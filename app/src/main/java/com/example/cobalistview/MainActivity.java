package com.example.cobalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mhslist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNama = (EditText) findViewById(R.id.edNama);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama = edNama.getText().toString();
                //Log.i("ISIAN NAMA = ", isian_nama);

                if(isian_nama.isEmpty()){
                    Toast.makeText(getApplicationContext(), "isian masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    daftar_nama.add(isian_nama);
                    edNama.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);

                }


            }
        });

        Button btnLihat = (Button) findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                startActivity(intent_list);

            }
        });
    }
}