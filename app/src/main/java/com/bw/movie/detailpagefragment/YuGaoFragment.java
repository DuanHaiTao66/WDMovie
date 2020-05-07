package com.bw.movie.detailpagefragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-25
 *@Time:16:15
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.detailadapter.YuGaoAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.DetailBean;
import com.bw.movie.contract.DetailPageContract;
import com.bw.movie.presenter.DetailPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class YuGaoFragment extends BaseFragment<DetailPresenterImpl> implements DetailPageContract.View {
    @BindView(R.id.yugao)
    RecyclerView yugao;

    @Override
    protected DetailPresenterImpl initPresenter() {
        return new DetailPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        yugao.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.yu_gao_fragment;
    }

    @Override
    protected void initData() {
        presenter.detail(13828,"158780337681613828",24);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof DetailBean) {
            DetailBean detailBean = (DetailBean) obj;
            List<DetailBean.ResultBean.ShortFilmListBean> shortFilmList = detailBean.getResult().getShortFilmList();
            YuGaoAdapter adapter = new YuGaoAdapter(shortFilmList, getContext());
            yugao.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
