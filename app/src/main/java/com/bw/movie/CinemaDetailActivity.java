package com.bw.movie;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.CinemaDetailBean;
import com.bw.movie.cinemadetailfragment.CinemaDetailFragment;
import com.bw.movie.cinemadetailfragment.CinemaEvaluateFragment;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.presenter.CinemaDetailPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CinemaDetailActivity extends BaseActivity<CinemaDetailPresenterImpl>implements CinemaDetailContract.View {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_movieName)
    TextView tvMovieName;
    @BindView(R.id.cb_aixin)
    CheckBox cbAixin;
    @BindView(R.id.tv_type1)
    TextView tvType1;
    @BindView(R.id.xtab_layout)
    XTabLayout xtabLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_showPaiXi)
    TextView tvShowPaiXi;
    private List<String>list = new ArrayList<>();
    private List<Fragment>fragmentList = new ArrayList<>();
    @Override
    protected CinemaDetailPresenterImpl initPresenter() {
        return new CinemaDetailPresenterImpl();
    }

    @Override
    protected void initData() {
        presenter.cinemaDetail(13828 ,"158892006050613828",5);
    }

    @Override
    protected void initView() {
        list.add("影院详情");
        list.add("影院评价");
        fragmentList.add(new CinemaDetailFragment());
        fragmentList.add(new CinemaEvaluateFragment());
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
        xtabLayout.setupWithViewPager(vp);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_cinema_detail;
    }


    @Override
    public void success(Object obj) {
        if (obj instanceof CinemaDetailBean){
            CinemaDetailBean cinemaDetailBean = (CinemaDetailBean) obj;
            CinemaDetailBean.ResultBean result = cinemaDetailBean.getResult();
            tvMovieName.setText(result.getName());
            tvType1.setText(result.getLabel());
        }
    }

    @Override
    public void filter(String msg) {

    }
}
