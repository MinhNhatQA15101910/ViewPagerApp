package com.donhat.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    private final ArrayList<Fragment> _fragments = new ArrayList<>();

    public MyViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return _fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return _fragments.size();
    }

    public void addFragment(Fragment fragment) {
        _fragments.add(fragment);
    }
}
