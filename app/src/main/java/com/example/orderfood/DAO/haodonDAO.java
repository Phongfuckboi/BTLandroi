package com.example.orderfood.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.hoadonDTO;
import com.example.orderfood.database.datamanager;

import java.util.ArrayList;
import java.util.List;

public class haodonDAO {
    private  SQLiteDatabase database;

    public void haodonDAO(Context context)
    {
        datamanager datamanager= new datamanager(context);

    }
     public  boolean Themhoadon(hoadonDTO hoadonDTO)
     {
         ContentValues contentValues= new ContentValues();
         contentValues.put(datamanager.TB_HOADON_MAHD, hoadonDTO.getMahd());
         contentValues.put(datamanager.TB_HOADON_MANV, hoadonDTO.getHd_manv());
         contentValues.put(datamanager.TB_HOADON_TENBAN, hoadonDTO.getHd_tenban());
         contentValues.put(datamanager.TB_HOADON_IDBAN, hoadonDTO.getHd_idban());
         contentValues.put(datamanager.TB_HOADON_TONGTIEN, hoadonDTO.getTongtien());
         contentValues.put(datamanager.TB_HOADON_NGAYTAO, hoadonDTO.getNgaytao());

         long kiemtra = database.insert(datamanager.TB_HOADON,null,contentValues);
         return kiemtra != 0;

     }

    @SuppressLint("Recycle")
    public List<hoadonDTO> LayDanhSachoadon(int maloai){
        List<hoadonDTO> hoadonDTO = new ArrayList<hoadonDTO>();

        String truyvan = "SELECT * FROM " + datamanager.TB_HOADON ;
        Cursor cursor = database.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            hoadonDTO hoadonDTO1 = new hoadonDTO();
            hoadonDTO1.setMahd(cursor.getInt(cursor.getColumnIndex(datamanager.TB_HOADON_MAHD)));
            hoadonDTO1.setHd_manv(cursor.getInt(cursor.getColumnIndex(datamanager.TB_HOADON_MANV)));
            hoadonDTO1.setHd_tenban(cursor.getString(cursor.getColumnIndex(datamanager.TB_HOADON_TENBAN)));
            hoadonDTO1.setNgaytao(cursor.getString(cursor.getColumnIndex(datamanager.TB_HOADON_NGAYTAO)));
            hoadonDTO1.setTongtien(cursor.getString(cursor.getColumnIndex(datamanager.TB_HOADON_TONGTIEN)));

            hoadonDTO.add(hoadonDTO1);
            cursor.moveToNext();
        }

        return hoadonDTO;
    }





}
