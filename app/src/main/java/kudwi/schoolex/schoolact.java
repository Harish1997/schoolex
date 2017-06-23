package kudwi.schoolex;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class schoolact extends AppCompatActivity {

    ViewPager viewPager;

    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager=(ViewPager)findViewById(R.id.pager);
        setupViewPager(viewPager);
        tablayout=(TabLayout)findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);

        if(tablayout!=null)
            tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPageAdapter viewpageadapter=new ViewPageAdapter(getSupportFragmentManager());
        viewpageadapter.add(new Fragment_1(),"About");
        viewpageadapter.add(new Fragment_2(),"Reviews");
        viewpageadapter.add(new Fragment_3(),"Chat");
        viewPager.setAdapter(viewpageadapter);
    }

    private class ViewPageAdapter extends FragmentPagerAdapter
    {
        List<Fragment> fragmentlist= new ArrayList<>();
        List<String> fragmenttitle=new ArrayList<>();
        public ViewPageAdapter(FragmentManager supportFragmentManager)
        {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return fragmentlist.size();
        }

        public void add(Fragment fragment, String title)
        {
            fragmentlist.add(fragment);
            fragmenttitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmenttitle.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuinfalter=getMenuInflater();
        menuinfalter.inflate(R.menu.menu_schoolact,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id== R.id.action_settings)
        {

        }
        return super.onOptionsItemSelected(item);
    }

}
