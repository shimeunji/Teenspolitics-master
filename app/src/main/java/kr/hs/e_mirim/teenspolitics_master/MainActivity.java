package kr.hs.e_mirim.teenspolitics_master;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("홈"));
        tabLayout.addTab(tabLayout.newTab().setText("콘텐츠"));
        tabLayout.addTab(tabLayout.newTab().setText("광장"));

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            public void onTabSelected(TabLayout.Tab tab){
                mViewPager.setCurrentItem(tab.getPosition());


            }
            public void onTabUnselected(TabLayout.Tab tab){

            }
            public void onTabReselected(TabLayout.Tab tab)
            {

            }

        });

    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        int tabcount;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public SectionsPagerAdapter(FragmentManager fm,int numberOfTabs)
        {
            super(fm);
            this.tabcount=numberOfTabs;
        }
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    HomeFragment tab1=new HomeFragment();
                    return tab1;
                case 1:
                    ContentsFragment tab2=new ContentsFragment();
                    return tab2;
                case 2:
                    JustnessFragment tab3=new JustnessFragment();
                    return tab3;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return tabcount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "홈";
                case 1:
                    return "콘텐츠";
                case 2:
                    return "광장";
            }
            return null;
        }
    }
}
