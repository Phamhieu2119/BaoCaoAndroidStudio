package com.example.btlandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PhimDAO
{
    DbHelper csdl;

    public PhimDAO(Context context) {

        csdl = new DbHelper(context);
    }
    public ArrayList<String> getKhuVuc(){
        String sql = "SELECT DISTINCT KhuVuc FROM Phim";
        ArrayList<String> dsKhuVuc = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("KhuVuc");
                do {
                    String khuVuc = cursor.getString(columnIndex);
                    dsKhuVuc.add(khuVuc);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsKhuVuc;
    }
    public ArrayList<String> getLoai(){
        String sql = "SELECT DISTINCT Loai FROM Phim";
        ArrayList<String> dsLoai = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("Loai");
                do {
                    String loai = cursor.getString(columnIndex);
                    dsLoai.add(loai);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsLoai;
    }
    public ArrayList<String> getPhude(){
        String sql = "SELECT DISTINCT PhuDe FROM Phim";
        ArrayList<String> dsPhude = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("PhuDe");
                do {
                    String phude = cursor.getString(columnIndex);
                    dsPhude.add(phude);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsPhude;
    }
    public ArrayList<String> getNam(){
        String sql = "SELECT DISTINCT NamPhatHanh FROM Phim";
        ArrayList<String> dsNam = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("NamPhatHanh");
                do {
                    String nam = cursor.getString(columnIndex);
                    dsNam.add(nam);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dsNam;
    }
    public ArrayList<Phim> getViewphim() {
        String sql = "SELECT * FROM Phim";
        ArrayList<Phim> ds = new ArrayList<>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int maPhim = cursor.getInt(cursor.getColumnIndex("MaPhim"));
                    String tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
                    String anhPhim = cursor.getString(cursor.getColumnIndex("anhPhim"));

                    // Tạo đối tượng Phim và thêm vào danh sách
                    Phim phim = new Phim(maPhim, tenPhim, anhPhim);
                    ds.add(phim);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ds;
    }




}
