package com.example.btlandroid;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvKhuvuc,rcvLoai,rcvPhude,rcvNam,rcvKhoPhim;
    private PhimDAO phimDAO;
    private PagerAdapter pagerAdapter , pagerAdapter1,pagerAdapter2,pagerAdapter3;
    private viewAdapter viewkhoPhim;
    private ArrayList<Phim> viewphim;
    private int centerPosition,centerPosition1,centerPosition2,centerPosition3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvKhuvuc = findViewById(R.id.view_khu_vuc);
        rcvKhuvuc.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        rcvLoai = findViewById(R.id.view_loai);
        rcvLoai.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        rcvPhude = findViewById(R.id.view_phu_de);
        rcvPhude.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        rcvNam = findViewById(R.id.view_nam);
        rcvNam.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        rcvKhoPhim = findViewById(R.id.view_kho_phim);
        //rcvKhoPhim.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));


        phimDAO = new PhimDAO(MainActivity.this);

        ArrayList<String> khuVuc = phimDAO.getKhuVuc();
        khuVuc.add(0,"Toàn bộ khu vực");
        pagerAdapter = new PagerAdapter(khuVuc, new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item, int position) {
                centerPosition = position;
                int screenWidth = getResources().getDisplayMetrics().widthPixels;
                LinearLayoutManager layoutManager = (LinearLayoutManager) rcvKhuvuc.getLayoutManager();
                View firstChildView = rcvKhuvuc.getChildAt(0);
                if (firstChildView != null) {
                    int itemWidth = firstChildView.getWidth();
                    if (layoutManager != null) {
                        layoutManager.scrollToPositionWithOffset(centerPosition, (screenWidth - itemWidth) / 2);
                    }
                }
            }
        });
        int spaceAroundItems = getResources().getDimensionPixelSize(R.dimen.space_around_items);
        rcvKhuvuc.addItemDecoration(new SpaceItem(spaceAroundItems));
        rcvKhuvuc.setAdapter(pagerAdapter);

        ArrayList<String> loai = phimDAO.getLoai();
        loai.add(0,"Toàn bộ các loại");
        pagerAdapter1 = new PagerAdapter(loai, new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item, int position) {
                centerPosition1 = position;
                int screenWidth = getResources().getDisplayMetrics().widthPixels;
                LinearLayoutManager layoutManager = (LinearLayoutManager) rcvLoai.getLayoutManager();
                View firstChildView = rcvLoai.getChildAt(0);
                if (firstChildView != null) {
                    int itemWidth = firstChildView.getWidth();
                    if (layoutManager != null) {
                        layoutManager.scrollToPositionWithOffset(centerPosition1, (screenWidth - itemWidth) / 2);
                    }
                }
            }
        });
        int spaceAroundItems1 = getResources().getDimensionPixelSize(R.dimen.space_around_items);
        rcvLoai.addItemDecoration(new SpaceItem(spaceAroundItems1));
        rcvLoai.setAdapter(pagerAdapter1);

        ArrayList<String> phude = phimDAO.getPhude();
        phude.add(0,"Toàn bộ phụ đề");
        pagerAdapter2 = new PagerAdapter(phude, new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item, int position) {
                centerPosition2 = position;
                int screenWidth = getResources().getDisplayMetrics().widthPixels;
                LinearLayoutManager layoutManager = (LinearLayoutManager) rcvPhude.getLayoutManager();
                View firstChildView = rcvPhude.getChildAt(0);
                if (firstChildView != null) {
                    int itemWidth = firstChildView.getWidth();
                    if (layoutManager != null) {
                        layoutManager.scrollToPositionWithOffset(centerPosition2, (screenWidth - itemWidth) / 2);
                    }
                }
            }
        });
        int spaceAroundItems2 = getResources().getDimensionPixelSize(R.dimen.space_around_items);
        rcvPhude.addItemDecoration(new SpaceItem(spaceAroundItems2));
        rcvPhude.setAdapter(pagerAdapter2);

        ArrayList<String> nam = phimDAO.getNam();
        nam.add(0,"Toàn bộ năm phát hành");
        pagerAdapter3 = new PagerAdapter(nam, new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item, int position) {
                centerPosition3 = position;
                int screenWidth = getResources().getDisplayMetrics().widthPixels;
                LinearLayoutManager layoutManager = (LinearLayoutManager) rcvNam.getLayoutManager();
                View firstChildView = rcvNam.getChildAt(0);
                if (firstChildView != null) {
                    int itemWidth = firstChildView.getWidth();
                    if (layoutManager != null) {
                        layoutManager.scrollToPositionWithOffset(centerPosition3, (screenWidth - itemWidth) / 2);
                    }
                }
            }
        });
        int spaceAroundItems3 = getResources().getDimensionPixelSize(R.dimen.space_around_items);
        rcvNam.addItemDecoration(new SpaceItem(spaceAroundItems3));
        rcvNam.setAdapter(pagerAdapter3);

        viewphim = phimDAO.getViewphim();
        viewkhoPhim = new viewAdapter(viewphim,MainActivity.this);
        rcvKhoPhim.setAdapter(viewkhoPhim);
        rcvKhoPhim.setLayoutManager(new GridLayoutManager(this, 3));
        rcvKhoPhim.setAdapter(viewkhoPhim);
    }
}