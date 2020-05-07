package com.bw.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.fragment.HomeFragment;
import com.bw.movie.fragmentlist.GGFragment;
import com.bw.movie.fragmentlist.HotFragment;
import com.bw.movie.fragmentlist.NowFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity {

    @BindView(R.id.tab)
    XTabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private List<String>list = new ArrayList<>();
    private List<Fragment>fragmentList = new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        list.add("正在上映");
        list.add("即将上映");
        list.add("热门电影");
        fragmentList.add(new NowFragment());
        fragmentList.add(new GGFragment());
        fragmentList.add(new HotFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tab.setupWithViewPager(vp);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_movie;
    }


}
