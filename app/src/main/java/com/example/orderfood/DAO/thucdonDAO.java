package com.example.orderfood.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.thucdonDTO;
import com.example.orderfood.database.datamanager;

import java.util.ArrayList;
import java.util.List;

public class thucdonDAO {

    private    SQLiteDatabase database;
    public thucdonDAO(Context context){
        datamanager datamanager = new datamanager(context);
//        database = createDatabase.open();
    }

    boolean themthucdon(thucdonDTO thucdonDTO)
    {
        ContentValues contentValues= new ContentValues();
        contentValues.put(datamanager.TB_THUCDON_IDMON,thucdonDTO.getIdmon());
        contentValues.put(datamanager.TB_THUCDON_TENMON,thucdonDTO.getTenmon());
        contentValues.put(datamanager.TB_THUCDON_GIA,thucdonDTO.getGia());
        contentValues.put(datamanager.TB_THUCDON_LOAI,thucdonDTO.getLoai());

        long kiemtra = database.insert(datamanager.TB_THUCDON,null,contentValues);
        return kiemtra != 0;
    }

    @SuppressLint("Recycle")
    public List<thucdonDTO> LayDanhSachMonAn(int maloai){
        List<thucdonDTO> monAnDTOs = new ArrayList<thucdonDTO>();

        String truyvan = "SELECT * FROM " + datamanager.TB_THUCDON + " WHERE " + datamanager.TB_THUCDON_IDMON + " = '" + maloai + "' ";
        Cursor cursor = database.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            thucdonDTO monAnDTO = new thucdonDTO();
            monAnDTO.setIdmon(cursor.getInt(cursor.getColumnIndex(datamanager.TB_THUCDON_IDMON)));
            monAnDTO.setTenmon(cursor.getString(cursor.getColumnIndex(datamanager.TB_THUCDON_TENMON)));
            monAnDTO.setGia(cursor.getString(cursor.getColumnIndex(datamanager.TB_THUCDON_GIA)));
            monAnDTO.setLoai(cursor.getString(cursor.getColumnIndex(datamanager.TB_THUCDON_LOAI)));

            monAnDTOs.add(monAnDTO);
            cursor.moveToNext();
        }

        return monAnDTOs;
    }

    }


