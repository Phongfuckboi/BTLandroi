package com.example.orderfood.DTO;

public class thucdonDTO {

private  int idmon;
private  String tenmon ,gia, loai;

    public thucdonDTO() {
    }

    public thucdonDTO(int idmon, String tenmon, String gia, String loai) {
        this.idmon = idmon;
        this.tenmon = tenmon;
        this.gia = gia;
        this.loai = loai;
    }

    public int getIdmon() {
        return idmon;
    }

    public void setIdmon(int idmon) {
        this.idmon = idmon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
