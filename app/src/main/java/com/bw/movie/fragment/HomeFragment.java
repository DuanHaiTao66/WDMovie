package com.bw.movie.fragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-17
 *@Time:15:14
 *@Description:${DESCRIPTION}
 **/

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.MovieActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.GGAdapter;
import com.bw.movie.adapter.HotAdapter;
import com.bw.movie.adapter.NowAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.GGBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.NowBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.presenter.HomePresenterImpl;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.View {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv1)
    RecyclerView rv1;
    @BindView(R.id.rv2)
    RecyclerView rv2;
    @BindView(R.id.rv3)
    RecyclerView rv3;
    @BindView(R.id.text_many1)
    TextView textMany1;
    @BindView(R.id.text_many2)
    TextView textMany2;
    @BindView(R.id.text_many3)
    TextView textMany3;

    @Override
    protected HomePresenterImpl initPresenter() {
        return new HomePresenterImpl();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv1.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rv2.setLayoutManager(linearLayoutManager1);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv3.setLayoutManager(gridLayoutManager);
        initBanner();
        initListener();
    }

    private void initListener() {
        textMany1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MovieActivity.class));
            }
        });
        textMany2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MovieActivity.class));
            }
        });
        textMany3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MovieActivity.class));
            }
        });
    }

    private void initBanner() {
        ArrayList<String> list = new ArrayList<>();
        list.add("http://mobile.bwstudent.com/images/movie/stills/whwdzg/whwdzg1_h.jpg");
        list.add("http://mobile.bwstudent.com/images/movie/stills/zgjz/zgjz1_h.jpg");
        list.add("http://mobile.bwstudent.com/images/movie/stills/pdz/pdz1_h.jpg");
        list.add("http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1_h.jpg");
        list.add("http://mobile.bwstudent.com/images/movie/stills/dwsj/dwsj1_h.jpg");
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(getContext()).load(path).into(imageView);
            }
        });
        banner.setImages(list);
        banner.setBannerAnimation(Transformer.Accordion);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER)
                .start();
        banner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),15);
            }
        });
        banner.setClipToOutline(true);
    }

    @Override
    protected int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initData() {
        presenter.now(1, 5);
        presenter.gg(1, 5);
        presenter.hot(1, 5);
    }

    @Override
    public void nowSuccess(Object obj) {
        if (obj instanceof NowBean) {
            NowBean nowBean = (NowBean) obj;
            List<NowBean.ResultBean> result = nowBean.getResult();
            NowAdapter adapter = new NowAdapter(result, getContext());
            rv1.setAdapter(adapter);
        }
    }

    @Override
    public void nowFilter(String msg) {

    }

    @Override
    public void ggSuccess(Object obj) {
        if (obj instanceof GGBean) {
            GGBean ggBean = (GGBean) obj;
            List<GGBean.ResultBean> result = ggBean.getResult();
            GGAdapter adapter = new GGAdapter(result, getContext());
            rv2.setAdapter(adapter);
        }
    }

    @Override
    public void ggFilter(String msg) {

    }

    @Override
    public void hotSuccess(Object obj) {
        if (obj instanceof HotBean) {
            HotBean hotBean = (HotBean) obj;
            List<HotBean.ResultBean> result = hotBean.getResult();
            HotAdapter adapter = new HotAdapter(result, getContext());
            rv3.setAdapter(adapter);
        }
    }

    @Override
    public void hotFilter(String msg) {

    }
}
