package com.example.orderfood.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.taikhoanDTO;
import com.example.orderfood.database.datamanager;

import java.util.ArrayList;
import java.util.List;

public class taikhoanDAO {

    private  final SQLiteDatabase database;


    public taikhoanDAO(SQLiteDatabase database) {
        this.database = database;
    }
    public taikhoanDAO(Context context, SQLiteDatabase database)
    {
        this.database = database;
        datamanager datamanager= new datamanager(context);
    }

    public boolean themNV(taikhoanDTO taikhoanDTO)
    {
        ContentValues contentValues= new ContentValues();

        //put cac truong du lieu
         contentValues.put(datamanager.TB_TAIKHOAN_TENDN,taikhoanDTO.getTendn());
         contentValues.put(datamanager.TB_TAIKHOAN_PASS, taikhoanDTO.getPass());
         contentValues.put(datamanager.TB_TAIKHOAN_TENNV,taikhoanDTO.getTen_nv());
         contentValues.put(datamanager.TB_TAIKHOAN_MANV,taikhoanDTO.getManv());
         contentValues.put(datamanager.TB_TAIKHOAN_QUYEN,taikhoanDTO.getQuyen());
        // thêm nhân vien
        long kiemtra = database.insert(datamanager.TB_TAIKHOAN, null,contentValues);
        return kiemtra != 0;

    }
    @SuppressLint("Recycle")
    public boolean KiemTraNhanVien(){
        String truyvan = "SELECT * FROM " + datamanager.TB_TAIKHOAN;
        Cursor cursor = database.rawQuery(truyvan, null); //rawQuery cho phép truy vấn câu query đơn giản
        return cursor.getCount() != 0;
    }
    @SuppressLint("Recycle")
    public int KiemTraDangNhap(String tendangnhap, String matkhau){
        String truyvan = "SELECT * FROM " + datamanager.TB_TAIKHOAN + " WHERE " + datamanager.TB_TAIKHOAN_TENDN + " = '" + tendangnhap
                + "' AND " + datamanager.TB_TAIKHOAN_PASS + " = '" + matkhau + "'";

        int manhanvien = 0;
        Cursor cursor = database.rawQuery(truyvan, null); //rawQuery cho phép truy vấn câu query đơn giản
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            manhanvien = cursor.getInt(cursor.getColumnIndex(datamanager.TB_TAIKHOAN_MANV));
            cursor.moveToNext();
        }

        return manhanvien;
    }
    @SuppressLint("Recycle")
    public List<taikhoanDTO> LayDanhSachTk(){
        List<taikhoanDTO> nhanvienDTOS = new ArrayList<>();
        String truyvan = "SELECT * FROM " + datamanager.TB_TAIKHOAN;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            taikhoanDTO nhanVienDTO = new taikhoanDTO();
            nhanVienDTO.setTendn(cursor.getString(cursor.getColumnIndex(datamanager.TB_TAIKHOAN_TENNV)));
            nhanVienDTO.setPass(cursor.getString(cursor.getColumnIndex(datamanager.TB_TAIKHOAN_PASS)));
            nhanVienDTO.setTen_nv(cursor.getString(cursor.getColumnIndex(datamanager.TB_TAIKHOAN_TENNV)));
            nhanVienDTO.setManv(cursor.getInt(cursor.getColumnIndex(datamanager.TB_TAIKHOAN_MANV)));
            nhanVienDTO.setQuyen(cursor.getString(cursor.getColumnIndex(datamanager.TB_TAIKHOAN_QUYEN)));


            nhanvienDTOS.add(nhanVienDTO);
            cursor.moveToNext();
        }

        return nhanvienDTOS;
    }

}
