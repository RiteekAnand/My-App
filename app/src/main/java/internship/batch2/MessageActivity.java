package internship.batch2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MessageActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar().hide();
        tabLayout = findViewById(R.id.message_tab);
        viewPager = findViewById(R.id.message_pager);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        viewPager.setAdapter(new MessageAdapter(getSupportFragmentManager()));

    }

    private class MessageAdapter extends FragmentPagerAdapter {
        public MessageAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Chat";
                case 1:
                    return "Status";
                case 2:
                    return "Call";
                case 3:
                    return "Chat";
                case 4:
                    return "Status";
                case 5:
                    return "Call";
            }
            return super.getPageTitle(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return new ChatFragment();
                case 1 : return new StatusFragment();
                case 2 : return new CallFragment();
                case 3 : return new ChatFragment();
                case 4 : return new StatusFragment();
                case 5 : return new CallFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}