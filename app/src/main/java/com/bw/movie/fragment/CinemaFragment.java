package com.bw.movie.fragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-17
 *@Time:15:14
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.cinemafragment.NearFragment;
import com.bw.movie.cinemafragment.RecommendFragment;
import com.bw.movie.cinemafragment.RegionFragment;
import com.bw.movie.fragmentlist.NowFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CinemaFragment extends BaseFragment {
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
    protected void initView(View inflate) {
        list.add("推荐影院");
        list.add("附近影院");
        list.add("地区");
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new NearFragment());
        fragmentList.add(new RegionFragment());
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        return R.layout.cinema_fragment;
    }

    @Override
    protected void initData() {

    }
}
