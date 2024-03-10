package com.example.btlandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    public DbHelper(@Nullable Context context) {
        super(context, "Phim4.sqlite", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlcreate = "CREATE TABLE IF NOT EXISTS " +
                "Phim(MaPhim INTEGER PRIMARY KEY, " +
                "TenPhim VARCHAR(200), " +
                "TheLoai VARCHAR(200), " +
                "KhuVuc VARCHAR(200), " +
                "Loai VARCHAR(200), " +
                "PhuDe VARCHAR(200), " +
                "NamPhatHanh INTEGER, " +
                "DaoDien VARCHAR(200), " +
                "DienVien VARCHAR(200)," +
                "anhPhim VARCHAR(255))"; // Add anhPhim column here
        db.execSQL(sqlcreate);

        // Insert data using ContentValues to avoid SQL injection
        insertPhim(db, 6, "ha", "Thanh xuan", "Dịch thủ công", 2020, "Doremon6", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRni1XJ0jPRIOjj-pXyieVRXUEG59MTvnhuJ3sx6wSw5w&s");
        insertPhim(db, 7, "ha giang", "LGBT", "Dịch thủ công", 2021, "Doremon7", "https://kenh14cdn.com/203336854389633024/2022/6/29/photo-1-16564949647361235505040.jpg");
        insertPhim(db, 8, "thanh pho ho chi minh", "Bí ẩn", "Dịch thủ công", 2022, "Doremon8", "https://ss-images.saostar.vn/w800/2019/05/21/5240143/8.jpg");
        insertPhim(db, 9, "hai duong", "Cổ Trang", "Dịch thủ công", 2019, "Doremon9", "https://truongptdtntthptdienbiendong.edu.vn/wp-content/uploads/2023/04/top-phim-doraemon-hay-nhat.jpg");
        insertPhim(db, 10, "hai phong", "Hài kịch", "Dịch thủ công", 2018, "Doremon10", "https://images.fbox.fpt.vn/wordpress-blog/2023/10/phim-hoat-hinh-doraemon.jpg");
        insertPhim(db, 11, "ha", "Thanh thi", "Dịch thủ công", 2005, "Doremon11", "https://i.pinimg.com/474x/71/d8/9b/71d89b86c1d7f58f526e9001b9b96d0e.jpg");
        insertPhim(db, 12, "ha giang", "LGBT", "Dịch thủ công", 2006, "Doremon12", "https://i.pinimg.com/564x/70/4c/68/704c68794c4f0767e42892ec208cad35.jpg");
        insertPhim(db, 13, "thanh pho ho chi minh", "Bí ẩn", "Dịch thủ công", 2007, "Doremon13", "https://img.ws.mms.shopee.vn/sg-11134201-22100-eig9580o2wiv24");
        insertPhim(db, 14, "hai duong", "lãng mạng", "Dịch thủ công", 2008, "Doremon14", "https://chungcuhuyndaihillstate.com/wp-content/uploads/2022/10/anh-doremon-cute-10.jpg");
        insertPhim(db, 15, "hai phong", "Hài kịch", "Dịch thủ công", 2009, "Doremon15", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuvZ1fXZfuZlOIEgzdRFnhm4g4NKCeu0mWrSCp33UvJPrlmUGebrW9g346HwMvm71ceOw&usqp=CAU");
        insertPhim(db, 16, "ha", "Thanh xuan", "Dịch thủ công", 2010, "Doremon16", "https://cdn.thanhtrungmobile.vn/thanhtrungmobile-vn/2022/01/hinh-nen-doremon-cute-4-1641715355.jpg");
        insertPhim(db, 17, "ha giang", "LGBT", "Dịch thủ công", 2011, "Doremon17", "https://phunugioi.com/wp-content/uploads/2020/03/hinh-anh-doremon-va-banh-ran.jpg");
        insertPhim(db, 18, "thanh pho ho chi minh", "Bí ẩn", "Dịch thủ công", 2012, "Doremon18", "https://chungcuquoctebooyoungvina.com/wp-content/uploads/2022/10/anh-doremon-cute-59.jpg");
        insertPhim(db, 19, "hai duong", "Cổ Trang", "Dịch thủ công", 2014, "Doremon19", "https://kiemtientuweb.com/ckfinder/userfiles/images/hinh-nen-doremon/doremon-44.jpg");
        insertPhim(db, 20, "hai phong", "Hài kịch", "Dịch thủ công", 2016, "Doremon20", "https://chungcuquoctebooyoungvina.com/wp-content/uploads/2022/10/anh-doremon-cute-52.jpg");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private void insertPhim(SQLiteDatabase db, int maPhim, String khuVuc, String loai, String phuDe, int namPhatHanh, String tenPhim, String anhPhim) {
        ContentValues values = new ContentValues();
        values.put("MaPhim", maPhim);
        values.put("KhuVuc", khuVuc);
        values.put("Loai", loai);
        values.put("PhuDe", phuDe);
        values.put("NamPhatHanh", namPhatHanh);
        values.put("TenPhim", tenPhim);
        values.put("anhPhim", anhPhim);
        db.insert("Phim", null, values);
    }

}
