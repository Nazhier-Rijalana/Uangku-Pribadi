package com.example.uangkupribadi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper{
    public static final String database_name = "db_uang";
    public static final String table_name = "keuangan";
    public static final String clm_id = "_id";
    public static final String clm_title = "title";
    public static final String clm_nominal = "nominal";
    public static final String clm_keperluan = "keperluan";
    private SQLiteDatabase db;

    public DB(Context context) {
        super(context, database_name, null, 2);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ table_name +"("+ clm_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ clm_title +" TEXT,"+ clm_nominal +"INTEGER, "+ clm_keperluan +" TEXT )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
    }
    public Cursor allData(){
        Cursor cur = db.rawQuery("SELECT * FROM " + table_name , null);
        return cur;
    }

    public Cursor oneData(Long id){
        Cursor cur = db.rawQuery("SELECT * FROM " + table_name + " WHERE " + clm_id + "=" + id, null);
        return cur;
    }
    public void insertData(ContentValues values){
        String q = "INSERT INTO " + table_name + " VALUES ( "+ values.get("title") +"," + values.get("nominal") + "," + values.get("keperluan") +")";
        db.execSQL(q);
    }
    public void updateData(ContentValues values, long id){
        db.update(table_name, values, clm_id + "=" + id, null);
    }
    public void deleteData(long id){
        db.delete(table_name, clm_id + "=" + id, null);
    }
}
