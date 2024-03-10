package com.example.btlandroid;

import java.io.Serializable;

public class Phim implements Serializable {
    private int maPhim,namPhathanh;
    private String tenPhim,theLoai,khuVuc,loai,phuDe,daoDien,dienVien;
    private String imageUrl;
    public Phim() {
    }

    public Phim(int maPhim, String tenPhim, String imageUrl) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.imageUrl = imageUrl;
    }

    public Phim(int namPhathanh, String tenPhim, String theLoai, String khuVuc, String loai, String phuDe, String daoDien, String dienVien) {
        this.namPhathanh = namPhathanh;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.khuVuc = khuVuc;
        this.loai = loai;
        this.phuDe = phuDe;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
    }

    public Phim(int maPhim, int namPhathanh, String tenPhim, String theLoai, String khuVuc, String loai, String phuDe, String daoDien, String dienVien) {
        this.maPhim = maPhim;
        this.namPhathanh = namPhathanh;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.khuVuc = khuVuc;
        this.loai = loai;
        this.phuDe = phuDe;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public int getNamPhathanh() {
        return namPhathanh;
    }

    public void setNamPhathanh(int namPhathanh) {
        this.namPhathanh = namPhathanh;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getPhuDe() {
        return phuDe;
    }

    public void setPhuDe(String phuDe) {
        this.phuDe = phuDe;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }
}
