package com.bw.movie.detailpagefragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-25
 *@Time:16:15
 *@Description:${DESCRIPTION}
 **/
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.detailadapter.GieShaoAdapter;
import com.bw.movie.adapter.detailadapter.YanYuanAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.DetailBean;
import com.bw.movie.contract.DetailPageContract;
import com.bw.movie.presenter.DetailPresenterImpl;

import java.util.List;
import butterknife.BindView;

public class GieShaoFragment extends BaseFragment<DetailPresenterImpl>implements DetailPageContract.View {
    @BindView(R.id.text_nr)
    TextView textNr;
    @BindView(R.id.dao_rv)
    RecyclerView daoRv;
    @BindView(R.id.yanyuan_rv)
    RecyclerView yanyuanRv;
    @Override
    protected DetailPresenterImpl initPresenter() {
        return new DetailPresenterImpl();
    }
    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        daoRv.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        yanyuanRv.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.jie_shao_fragment;
    }

    @Override
    protected void initData() {
        presenter.detail(13828,"158786905715113828",24);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof DetailBean){
            DetailBean detailBean = (DetailBean) obj;
            DetailBean.ResultBean result = detailBean.getResult();
            String summary = result.getSummary();
            textNr.setText(summary);

            List<DetailBean.ResultBean.MovieDirectorBean> movieDirector = detailBean.getResult().getMovieDirector();
            GieShaoAdapter adapter = new GieShaoAdapter(movieDirector,getContext());
            daoRv.setAdapter(adapter);

            List<DetailBean.ResultBean.MovieActorBean> movieActor = detailBean.getResult().getMovieActor();
            YanYuanAdapter yanYuanAdapter = new YanYuanAdapter(movieActor,getContext());
            yanyuanRv.setAdapter(yanYuanAdapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
