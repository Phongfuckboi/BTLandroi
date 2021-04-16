package com.example.orderfood.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.bananDTO;
import com.example.orderfood.database.datamanager;

import java.util.ArrayList;
import java.util.List;

public class bananDAO {
   static SQLiteDatabase database ;



    public bananDAO(Context context){
        datamanager createDatabase = new datamanager(context);
        database = createDatabase.open();
    }
    public static boolean ThemBanAn(String tenban){
        ContentValues contentValues = new ContentValues();
        contentValues.put(datamanager.TB_BANAN_TENBAN, tenban);
        contentValues.put(datamanager.TB_BANAN_TINHTRANG, "false");
        long kiemtra = database.insert(datamanager.TB_BANAN, null, contentValues);
        return kiemtra != 0;
    }

    @SuppressLint("Recycle")
    public List<bananDTO> LayTatCaBanAn(){
        List<bananDTO> banAnDTOList = new ArrayList<>();
        String truyvan= "SELECT * FROM " + datamanager.TB_BANAN;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            bananDTO banAnDTO = new bananDTO();
            banAnDTO.setIdban(cursor.getInt(cursor.getColumnIndex(datamanager.TB_BANAN_MABAN)));
            banAnDTO.setTenban(cursor.getString(cursor.getColumnIndex(datamanager.TB_BANAN_TENBAN)));
            banAnDTO.setTinhtrang(cursor.getString(cursor.getColumnIndex(datamanager.TB_BANAN_TINHTRANG)));
            banAnDTOList.add(banAnDTO);
            cursor.moveToNext();
        }
        return banAnDTOList;
    }

    @SuppressLint("Recycle")
    public String LayTinhTrangBan(int maban){
        String tinhtrang = "";
        String truyvan = "SELECT * FROM " + datamanager.TB_BANAN + " WHERE " + datamanager.TB_BANAN_MABAN + " = '" + maban + "'";
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tinhtrang = cursor.getString(cursor.getColumnIndex(datamanager.TB_BANAN_TINHTRANG));
            cursor.moveToNext();
        }

        return tinhtrang;
    }

    public boolean CapNhatTinhTrangBan(int maban, String tinhtrang){
        ContentValues contentValues = new ContentValues();
        contentValues.put(datamanager.TB_BANAN_TINHTRANG, tinhtrang);

        long kiemtra = database.update(datamanager.TB_BANAN, contentValues, datamanager.TB_BANAN_MABAN + " = '" + maban + "'", null);
        return kiemtra != 0;
    }

    public boolean CapNhatTenBan(int maban, String tenban){
        ContentValues contentValues = new ContentValues();
        contentValues.put(datamanager.TB_BANAN_TENBAN, tenban);

        long kiemtra = database.update(datamanager.TB_BANAN, contentValues, datamanager.TB_BANAN_MABAN + " = '" + maban + "'", null);
        return kiemtra != 0;
    }

    public boolean XoaBanAn(int maban){
        long kiemtra = database.delete(datamanager.TB_BANAN, datamanager.TB_BANAN_MABAN + " = " + maban, null);
        return kiemtra != 0;
    }

}
