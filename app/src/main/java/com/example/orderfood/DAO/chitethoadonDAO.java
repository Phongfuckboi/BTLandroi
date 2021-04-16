package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.chitiethoadonDTO;
import com.example.orderfood.DTO.hoadonDTO;
import com.example.orderfood.database.datamanager;

import java.util.ArrayList;
import java.util.List;

public class chitethoadonDAO {
    private SQLiteDatabase database;
    public  chitethoadonDAO(Context context)
    {
        datamanager datamanager= new datamanager(context);
    }
    public List<chitiethoadonDTO> laydscthd(int maloai)





    {
        List<chitiethoadonDTO> cthd = new ArrayList<>();

        String truyvan = "SELECT * FROM " + datamanager.TB_CHITIETHOADON  ;
        Cursor cursor = database.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            chitiethoadonDTO hoadonDTO1 = new chitiethoadonDTO();
            hoadonDTO1.setCthd_mahd(cursor.getInt(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_MAHD)));
            hoadonDTO1.setCthd_idmon(cursor.getInt(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_IDMON)));
            hoadonDTO1.setCthd_tenmon(cursor.getString(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_TENMON)));
            hoadonDTO1.setSoluong(cursor.getInt(cursor.getColumnIndex(datamanager.TB_HOADON_NGAYTAO)));
            hoadonDTO1.setCthd_gia(cursor.getString(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_GIA)));
            hoadonDTO1.setCthd_ngaytao(cursor.getString(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_NGAYTAO)));
            hoadonDTO1.setCthd_manv(cursor.getInt(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_MANV)));
            hoadonDTO1.setCthd_idban(cursor.getInt(cursor.getColumnIndex(datamanager.TB_CHITIETHOADON_IDBAN)));


            cthd.add(hoadonDTO1);
            cursor.moveToNext();
        }
        return cthd;
    }


}

