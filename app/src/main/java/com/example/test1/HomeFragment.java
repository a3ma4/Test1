package com.example.test1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;

public class HomeFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        HomePagerAdapter adapter = new HomePagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: tab.setText("Tab 1"); break;
                        case 1: tab.setText("Tab 2"); break;
                        case 2: tab.setText("Tab 3"); break;
                    }
                }).attach();

        return view;
    }

    public boolean handleBackPressed() {
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0);
            return true;
        }
        return false;
    }
}
