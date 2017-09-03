package com.bubble.swcamp.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.adapter.MainFiltersAdapter;
import com.bubble.swcamp.android.adapter.MainRankerPagerAdapter;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by geni on 2017. 8. 31..
 */

public class Main extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private DrawerLayout mDrawerLayout;

    private ImageView bgProfile;
    private CircleImageView bgCircleProfile;
    private TextView nickName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewPager = (ViewPager)findViewById(R.id.ranker);
        tabLayout = (TabLayout)findViewById(R.id.tabDots);
        recyclerView = (RecyclerView)findViewById(R.id.filters);

        recyclerView.setAdapter(new MainFiltersAdapter(getApplicationContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(new MainRankerPagerAdapter(getApplicationContext()));

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View navHeaderView = navigationView.getHeaderView(0);

        navHeaderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MyPage.class));
            }
        });

        bgProfile = (ImageView)navHeaderView.findViewById(R.id.bg_profile);
        bgCircleProfile = (CircleImageView)navHeaderView.findViewById(R.id.bg_circle_profile);
        Glide.with(getApplicationContext()).load(R.drawable.heize).into(bgProfile);
        Glide.with(getApplicationContext()).load(R.drawable.heize).into(bgCircleProfile);
        nickName = (TextView)navHeaderView.findViewById(R.id.nickName);

        //navigationDrawer의 아이템들의 클릭이벤트를 처리해주는 코드
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.nav_item_my_preset:
                        startActivity(new Intent(getApplicationContext(), MyPreset.class));
                        break;
                    case R.id.nav_item_upload_preset:
                        startActivity(new Intent(getApplicationContext(), UploadedPreset.class));
                        break;
                    case R.id.nav_item_bubble_market:
                        startActivity(new Intent(getApplicationContext(), BubbleMarket.class));
                        break;
                    case R.id.nav_item_my_page:
                        startActivity(new Intent(getApplicationContext(), MyPage.class));
                        break;
                }
                return true;
            }
        });
    }

    public void navDrawerOnClick(View v){
        mDrawerLayout.openDrawer(GravityCompat.START);
    }
}
