package com.donhat.viewpagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 _viewPager2;
    private TabLayout _tabLayout;

    private MyViewPagerAdapter _myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();

        _myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        _myViewPagerAdapter.addFragment(new Fragment1());
        _myViewPagerAdapter.addFragment(new Fragment2());
        _myViewPagerAdapter.addFragment(new Fragment3());

        _viewPager2.setAdapter(_myViewPagerAdapter);

        new TabLayoutMediator(
                _tabLayout,
                _viewPager2,
                (tab, i) -> tab.setText("Fragment " + (i + 1))
        ).attach();
    }

    void initializeViews() {
        _viewPager2 = findViewById(R.id.view_pager_2);
        _tabLayout = findViewById(R.id.tab_layout);
    }
}