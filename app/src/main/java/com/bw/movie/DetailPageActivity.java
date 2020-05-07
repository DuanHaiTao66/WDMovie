package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.DetailBean;
import com.bw.movie.contract.DetailPageContract;
import com.bw.movie.detailpagefragment.GieShaoFragment;
import com.bw.movie.detailpagefragment.GuZhaoFragment;
import com.bw.movie.detailpagefragment.YingPingFragment;
import com.bw.movie.detailpagefragment.YuGaoFragment;
import com.bw.movie.presenter.DetailPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPageActivity extends BaseActivity<DetailPresenterImpl> implements DetailPageContract.View {

   /* @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    XTabLayout tab;*/

    @BindView(R.id.detail_image)
    ImageView detailImage;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.pinglun)
    TextView pinglun;
    @BindView(R.id.detail_name)
    TextView detailName;
    @BindView(R.id.detail_time)
    TextView detailTime;
    @BindView(R.id.detail_data)
    TextView detailData;
    @BindView(R.id.write_movie_comment)
    Button writeMovieComment;
    @BindView(R.id.cb_aixin)
    CheckBox cbAixin;

    private List<String> list = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected DetailPresenterImpl initPresenter() {
        return new DetailPresenterImpl();
    }

    @Override
    protected void initData() {
        presenter.detail(13828, "158813549125113828", 24);
    }

    @Override
    protected void initView() {
        list.add("介绍");
        list.add("预告");
        list.add("剧照");
        list.add("影评");
        fragmentList.add(new GieShaoFragment());
        fragmentList.add(new YuGaoFragment());
        fragmentList.add(new GuZhaoFragment());
        fragmentList.add(new YingPingFragment());
       /* vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tab.setupWithViewPager(vp);*/
        initListener();
    }

    private void initListener() {
        writeMovieComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailPageActivity.this, PingLunActivity.class));
            }
        });
        cbAixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbAixin.isChecked()){
                    cbAixin.setChecked(true);
                    cbAixin.setText("已关注");
                }else{
                    cbAixin.setChecked(false);
                    cbAixin.setText("未关注");
                }
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_detail_page;
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof DetailBean) {
            DetailBean detailBean = (DetailBean) obj;
            DetailBean.ResultBean result = detailBean.getResult();
            Glide.with(this).load(result.getImageUrl()).into(detailImage);
            score.setText("评分:" + result.getScore() + "" + "分");
            pinglun.setText("评论:" + result.getCommentNum() + "万条");
            detailName.setText(result.getName());
            detailTime.setText(result.getDuration());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String format = simpleDateFormat.format(result.getReleaseTime());
            detailData.setText(format + "\t\t中国大陆上映");
        }
    }

    @Override
    public void filter(String msg) {

    }




}
