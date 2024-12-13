package com.dreamb.burgerking_copy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Fragment fragment_home_activity;
    Fragment fragment_cupon_activity;
    Fragment fragment_more_activity;
    Fragment fragment_my_king_activity;
    Fragment fragment_order_activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home_activity = new HomeActivity();
        fragment_cupon_activity = new CuponActivity();
        fragment_order_activity = new OrderActivity();
        fragment_my_king_activity = new MyKingActivity();
        fragment_more_activity = new MoreActivity();

        bottomNavigationView = findViewById(R.id.main_bottom_nav);

        //처음 시작화면
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayoutFrame, fragment_home_activity).commitAllowingStateLoss();

        //바텀 네비게이션 뷰 안에 아이템 설정하기
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayoutFrame, fragment_home_activity).commitAllowingStateLoss();
                    return true;
                } else if (itemId == R.id.cupon) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayoutFrame, fragment_cupon_activity).commitAllowingStateLoss();
                    return true;
                } else if (itemId == R.id.order) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayoutFrame, fragment_order_activity).commitAllowingStateLoss();
                    return true;
                } else if (itemId == R.id.myking) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayoutFrame, fragment_my_king_activity).commitAllowingStateLoss();
                    return true;
                } else if (itemId == R.id.more) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayoutFrame, fragment_more_activity).commitAllowingStateLoss();
                    return true;
                }
                return true;
            }
        });
    }
}