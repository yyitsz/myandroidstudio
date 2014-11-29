package org.yy.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by chinanet on 2014/11/27.
 */
public class CrimePagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<Crime> crimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);
        setContentView(viewPager);


        crimes = CrimeLab.get(this).getCrimes();

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int i) {
                return CrimeFragment.newInstance(crimes.get(i).getId());
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                Crime c = crimes.get(i);
                if(c.getTitle() != null) {
                    setTitle(c.getTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        UUID id = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getId().equals(id)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
