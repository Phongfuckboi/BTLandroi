package com.example.orderfood.DTO;

public class chitiethoadonDTO {

    private int cthd_manv, cthd_mahd, cthd_idmon, soluong , cthd_idban;
    private  String  cthd_tenmon, cthd_ngaytao, cthd_gia;


    public chitiethoadonDTO() {
    }

    public chitiethoadonDTO(int cthd_manv, int cthd_mahd, int cthd_idmon, int soluong, String cthd_tenmon, String cthd_ngaytao, String cthd_gia, int cthd_idban) {
        this.cthd_manv = cthd_manv;
        this.cthd_mahd = cthd_mahd;
        this.cthd_idmon = cthd_idmon;
        this.soluong = soluong;
        this.cthd_tenmon = cthd_tenmon;
        this.cthd_ngaytao = cthd_ngaytao;
        this.cthd_gia = cthd_gia;
        this.cthd_idban=cthd_idban;
    }

    public int getCthd_manv() {
        return cthd_manv;
    }

    public void setCthd_manv(int cthd_manv) {
        this.cthd_manv = cthd_manv;
    }

    public int getCthd_mahd() {
        return cthd_mahd;
    }

    public void setCthd_mahd(int cthd_mahd) {
        this.cthd_mahd = cthd_mahd;
    }

    public int getCthd_idmon() {
        return cthd_idmon;
    }

    public void setCthd_idmon(int cthd_idmon) {
        this.cthd_idmon = cthd_idmon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getCthd_tenmon() {
        return cthd_tenmon;
    }

    public void setCthd_tenmon(String cthd_tenmon) {
        this.cthd_tenmon = cthd_tenmon;
    }

    public String getCthd_ngaytao() {
        return cthd_ngaytao;
    }

    public void setCthd_ngaytao(String cthd_ngaytao) {
        this.cthd_ngaytao = cthd_ngaytao;
    }

    public String getCthd_gia(String string) {
        return cthd_gia;
    }

    public void setCthd_gia(String cthd_gia) {
        this.cthd_gia = cthd_gia;
    }

    public int getCthd_idban() {
        return cthd_idban;
    }

    public void setCthd_idban(int cthd_idban) {
        this.cthd_idban = cthd_idban;
    }

    public String getCthd_gia() {
        return cthd_gia;
    }
}

