package com.example.uangkupribadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TampilkanData extends AppCompatActivity {
    ListView listView;
    DB dbhelper;
    LayoutInflater inflater;
    Button newData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_data);
        dbhelper = new DB(this);
        listView = (ListView)findViewById(R.id.list_data);
        newData = (Button)findViewById(R.id.newData);
        newData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TampilkanData. this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setListView(){
        Cursor cursor = dbhelper.allData();
        CustomCursorAdapterUang customCursorAdapter = new CustomCursorAdapterUang(this, cursor, 1);
        listView.setAdapter(customCursorAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setListView();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}