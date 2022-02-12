package com.example.uangkupribadi;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapterUang extends CursorAdapter{

    private LayoutInflater layoutInflater;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapterUang(Context context, Cursor c, int flags) {
        super(context, c, flags);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.row_data, viewGroup, false);
        MyHolderUang holder = new MyHolderUang();
        holder.ListID = (TextView)v.findViewById(R.id.listID);
        holder.Listtanggal = (TextView)v.findViewById(R.id.Listtanggal);
        holder.Listnominal = (TextView)v.findViewById(R.id.Listnominal);
        holder.Listkeperluan = (TextView)v.findViewById(R.id.Listkeperluan);
        v.setTag(holder);
        return null;
    }
    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolderUang holder = (MyHolderUang)view.getTag();
        holder.ListID.setText(cursor.getString(cursor.getColumnIndex(DB.clm_id)));
        holder.Listtanggal.setText(cursor.getString(cursor.getColumnIndex(DB.clm_title)));
        holder.Listnominal.setText(cursor.getString(cursor.getColumnIndex(DB.clm_nominal)));
        holder.Listkeperluan.setText(cursor.getString(cursor.getColumnIndex(DB.clm_keperluan)));
    }
    class MyHolderUang{
        TextView ListID;
        TextView Listsaldo_bulan;
        TextView Listtanggal;
        TextView Listuang_keluar;
        TextView Listnominal;
        TextView Listkeperluan;
        TextView Listuang_masuk;
    }
}
