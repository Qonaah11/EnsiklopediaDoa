package com.example.qonaah.ensiklopediadoa.model;

import java.io.Serializable;

/**
 * Created by Qona'ah on 10/1/2016.
 */

public class Nama implements Serializable {

    private int id;
    private String nama;
    private String keterangan;
    private String image;

    public Nama() {
    }

    public Nama(String image, String keterangan, String nama) {
        this.image = image;
        this.keterangan = keterangan;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Nama{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", video='" + image + '\'' +
                '}';
    }

}