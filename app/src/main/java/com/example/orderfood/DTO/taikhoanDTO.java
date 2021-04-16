package com.example.orderfood.DTO;

public class taikhoanDTO {
    int manv;
    private  String tendn, pass,ten_nv,quyen;

    public taikhoanDTO() {
    }

    public taikhoanDTO(String tendn, String pass, String ten_nv, int  manv, String quyen) {
        this.tendn = tendn;
        this.pass = pass;
        this.ten_nv = ten_nv;
        this.manv = manv;
        this.quyen = quyen;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
}
