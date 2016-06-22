package com.paintphobia.heri.belajarandroid.mainMenu;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.paintphobia.heri.belajarandroid.R;
import com.paintphobia.heri.belajarandroid.mainMenu.fragments.FragmentAbout;
import com.paintphobia.heri.belajarandroid.mainMenu.fragments.FragmentMasjid;
import com.paintphobia.heri.belajarandroid.mainMenu.fragments.FragmentSholat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMenuActivity extends AppCompatActivity
        implements FragmentSholat.OnFragmentInteractionListener,
        FragmentMasjid.OnFragmentInteractionListener,
        FragmentAbout.OnFragmentInteractionListener {

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_tab_sholat,
            R.drawable.ic_tab_masjid,
            R.drawable.ic_tab_about
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.Sholat)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.Masjid)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.About)));

        final ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//
//        setupViewPager(viewPager);
//        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new FragmentSholat(), this.getResources().getString(R.string.Sholat));
//        adapter.addFragment(new FragmentMasjid(), this.getResources().getString(R.string.Masjid));
//        adapter.addFragment(new FragmentAbout(), this.getResources().getString(R.string.About));
//        viewPager.setAdapter(adapter);
//    }

    private void setupTabIcons() {
        for(int i = 0; i< tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private int numTab;

        public ViewPagerAdapter(FragmentManager manager, int numTab) {
            super(manager);
            this.numTab = numTab;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    FragmentSholat fragmentSholat = new FragmentSholat();
                    return fragmentSholat;
                case 1:
                    FragmentMasjid fragmentMasjid = new FragmentMasjid();
                    return fragmentMasjid;
                case 2:
                    FragmentAbout fragmentAbout = new FragmentAbout();
                    return fragmentAbout;
                default:
                    FragmentSholat fragmentSholatDefault = new FragmentSholat();
                    return fragmentSholatDefault;
            }
        }

        @Override
        public int getCount() {
            return this.numTab;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabLayout.getTabAt(position).getText();
        }
    }
}
