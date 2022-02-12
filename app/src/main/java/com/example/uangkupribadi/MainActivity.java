package com.example.uangkupribadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_Tanggal, editText_Nominal, editText_Keperluan;
    DB dbhelper;
    Button button,tampilData;
    long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB dbhelper = new DB(this);
        id = getIntent().getLongExtra(DB.clm_id, 0);
        editText_Tanggal = findViewById(R.id.editText_tanggal);
        editText_Nominal = findViewById(R.id.editText_Nominal);
        editText_Keperluan = findViewById(R.id.editText_Keperluan);
        tampilData = findViewById(R.id.tampildata);
        tampilData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TampilkanData.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database();
            }
        });
    }
    private void Database(){

        String Tanggal = editText_Tanggal.getText().toString();
        String Nominal = editText_Nominal.getText().toString();
        String Keperluan = editText_Keperluan.getText().toString();
        ContentValues values = new ContentValues();
        values.put(DB.clm_title, Tanggal);
        values.put(DB.clm_nominal, Nominal);
        values.put(DB.clm_keperluan, Keperluan);
        Log.d("E", values.toString());
        if (Tanggal.equals("") || Nominal.equals("") || Keperluan.equals("")){
            Toast.makeText(MainActivity.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else {
            dbhelper.insertData(values);
            Toast.makeText(MainActivity.this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show();
        }
    }
}