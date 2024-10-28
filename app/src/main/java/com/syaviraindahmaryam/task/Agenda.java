package com.syaviraindahmaryam.task;

public class Agenda {
    private int id;
    private String nama;
    private String deskripsi;
    private String status;

    public Agenda(int id, String nama, String deskripsi, String status) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getStatus() { return status; }
}
