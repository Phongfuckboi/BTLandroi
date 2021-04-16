package com.example.orderfood.DTO;

public class hoadonDTO {
    private  int mahd, hd_manv, hd_idban;
    private  String hd_tenban, tongtien ,ngaytao;

    public hoadonDTO() {
    }

    public hoadonDTO(int mahd, int hd_manv, int hd_idban, String hd_tenban, String tongtien, String ngaytao) {
        this.mahd = mahd;
        this.hd_manv = hd_manv;
        this.hd_idban = hd_idban;
        this.hd_tenban = hd_tenban;
        this.tongtien = tongtien;
        this.ngaytao = ngaytao;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getHd_manv() {
        return hd_manv;
    }

    public void setHd_manv(int hd_manv) {
        this.hd_manv = hd_manv;
    }

    public int getHd_idban() {
        return hd_idban;
    }

    public void setHd_idban(int hd_idban) {
        this.hd_idban = hd_idban;
    }

    public String getHd_tenban() {
        return hd_tenban;
    }

    public void setHd_tenban(String hd_tenban) {
        this.hd_tenban = hd_tenban;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
}
