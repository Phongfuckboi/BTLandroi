package com.example.orderfood.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class datamanager extends SQLiteOpenHelper {

    //TEN CAC BANG
    public static String TB_TAIKHOAN = "TAIKHOAN";
    public static String TB_THUCDON = "THUCDON";
    public static String TB_BANAN = "BANAN";
    public static String TB_HOADON = "HOADON";
    public static String TB_CHITIETHOADON = "CHITIETHOADON";

    //THANH PHAN BANG TAI KHOAN
    public static String TB_TAIKHOAN_TENDN = "TENDN";
    public static String TB_TAIKHOAN_PASS = "PASS";
    public static String TB_TAIKHOAN_TENNV = "TENNV";
    public static String TB_TAIKHOAN_MANV = "MANV";
    public static String TB_TAIKHOAN_QUYEN = "QUYEN";


    //BANG THUC DON
    public static String TB_THUCDON_IDMON = "IDMON";
    public static String TB_THUCDON_TENMON = "TENMON";
    public static String TB_THUCDON_GIA = "GIA";
    public static String TB_THUCDON_LOAI = "LOAI";

    //BANG BAN AN
    public static String TB_BANAN_MABAN = "MABAN";
    public static String TB_BANAN_TENBAN = "TENBAN";
    public static String TB_BANAN_TINHTRANG = "TINHTRANG";

    //BANG HOA DON
    public static String TB_HOADON_MAHD = "MAHD";
    public static String TB_HOADON_MANV = "MANV";
    public static String TB_HOADON_TENBAN = "TENBAN";
    public static String TB_HOADON_IDBAN = "IDBAN";
    public static String TB_HOADON_TONGTIEN = "TONGTIEN";
    public static String TB_HOADON_NGAYTAO = "NGAYTAO";


    //BANG CHI TIET HOA DON
    public static String TB_CHITIETHOADON_MAHD = "MAHD";
    public static String TB_CHITIETHOADON_IDMON = "IDMON";
    public static String TB_CHITIETHOADON_TENMON = "TENMON";
    public static String TB_CHITIETHOADON_SOLUONG = "SOLUONG";
    public static String TB_CHITIETHOADON_GIA = "GIA";
    public static String TB_CHITIETHOADON_NGAYTAO = "NGAYTAO";
    public static String TB_CHITIETHOADON_MANV= "MANV";
    public static String TB_CHITIETHOADON_IDBAN="IDBAN";


    public datamanager( Context context) {
        super(context, "ORDER_FOOD",null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    //cau lenh toa bang
        //bang tai khoan
        String tbTAIKHOAN = "CREATE TABLE " + TB_TAIKHOAN + " ( " + TB_TAIKHOAN_TENDN + " TEXT, " + TB_TAIKHOAN_PASS + " TEXT, "
                + TB_TAIKHOAN_TENNV + " TEXT, " + TB_TAIKHOAN_MANV + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + TB_TAIKHOAN_QUYEN + " TEXT )";

        //bang ban
        String tbBANAN = "CREATE TABLE " + TB_BANAN + " ( " + TB_BANAN_MABAN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_BANAN_TENBAN + " TEXT, " + TB_BANAN_TINHTRANG + " TEXT )";

        //THUC DON
        String tbTHUCDON = "CREATE TABLE " + TB_THUCDON + " ( " + TB_THUCDON_IDMON + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + TB_THUCDON_TENMON + " TEXT, "
                + TB_THUCDON_GIA + " TEXT, "   + TB_THUCDON_LOAI + " TEXT )";

        //HOADON
        String tbHOADON = "CREATE TABLE " + TB_HOADON + " ( " + TB_HOADON_MAHD + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + TB_HOADON_MANV+ " INTEGER, "
                + TB_HOADON_TENBAN + " TEXT, "  + TB_HOADON_IDBAN + " INTEGER, "  + TB_HOADON_TONGTIEN + " TEXT, "   + TB_HOADON_NGAYTAO + " TEXT )";
        //CHI TIET HOA DON
        String tbCHITIETHOADON = "CREATE TABLE " + TB_CHITIETHOADON + " ( " + TB_CHITIETHOADON_MAHD + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + TB_CHITIETHOADON_IDMON+ " INTERGER, "
                + TB_CHITIETHOADON_TENMON + " TEXT, "  + TB_CHITIETHOADON_SOLUONG + " INTEGER, "  + TB_CHITIETHOADON_GIA + " TEXT, "
                + TB_CHITIETHOADON_NGAYTAO+ " TEXT, "  + TB_CHITIETHOADON_MANV+ " INTEGER, " + TB_CHITIETHOADON_IDBAN + " INTEGER )";


        // THUC THI CAU LENH
        db.execSQL(tbTAIKHOAN);
        db.execSQL(tbBANAN);
        db.execSQL(tbTHUCDON);
        db.execSQL(tbHOADON);
        db.execSQL(tbCHITIETHOADON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
