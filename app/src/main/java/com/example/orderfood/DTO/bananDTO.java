package com.example.orderfood.DTO;

public class bananDTO {
    private  int idban;
    private  String tenban , tinhtrang;
    private boolean DuocChon;

    public boolean isDuocChon() {
        return DuocChon;
    }
    public void setDuocChon(boolean duocChon) {
        DuocChon = duocChon;
    }

    public bananDTO() {
    }

    public bananDTO(int idban, String tenban, String tinhtrang) {
        this.idban = idban;
        this.tenban = tenban;
        this.tinhtrang = tinhtrang;
    }

    public int getIdban() {
        return idban;
    }

    public void setIdban(int idban) {
        this.idban = idban;
    }

    public String getTenban() {
        return tenban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
