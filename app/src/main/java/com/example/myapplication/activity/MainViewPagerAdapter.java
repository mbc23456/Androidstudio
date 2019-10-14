package com.example.myapplication.activity;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

class MainViewPagerAdapter extends PagerAdapter {
    public MainViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> fragments) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
