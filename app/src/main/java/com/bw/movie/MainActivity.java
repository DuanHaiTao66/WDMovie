package com.bw.movie;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bw.movie.fragment.CinemaFragment;
import com.bw.movie.fragment.HomeFragment;
import com.bw.movie.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.home_false)
    ImageView homeFalse;
    @BindView(R.id.home_true)
    LinearLayout homeTrue;
    @BindView(R.id.cinema_false)
    ImageView cinemaFalse;
    @BindView(R.id.cinema_true)
    LinearLayout cinemaTrue;
    @BindView(R.id.my_false)
    ImageView myFalse;
    @BindView(R.id.my_true)
    LinearLayout myTrue;
    private List<Fragment>fragmentList = new ArrayList<>();
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CinemaFragment());
        fragmentList.add(new MyFragment());
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame,fragmentList.get(0))
                .add(R.id.frame,fragmentList.get(1))
                .add(R.id.frame,fragmentList.get(2))
                .show(fragmentList.get(0))
                .hide(fragmentList.get(1))
                .hide(fragmentList.get(2))
                .commit();
    }
    @OnClick({R.id.home, R.id.cinema, R.id.my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                homeTrue.setVisibility(View.VISIBLE);
                homeFalse.setVisibility(View.GONE);
                cinemaFalse.setVisibility(View.VISIBLE);
                cinemaTrue.setVisibility(View.GONE);
                myFalse.setVisibility(View.VISIBLE);
                myTrue.setVisibility(View.GONE);
                manager.beginTransaction().show(fragmentList.get(0)).hide(fragmentList.get(1)).hide(fragmentList.get(2)).commit();
                break;
            case R.id.cinema:
                cinemaTrue.setVisibility(View.VISIBLE);
                cinemaFalse.setVisibility(View.GONE);
                homeFalse.setVisibility(View.VISIBLE);
                homeTrue.setVisibility(View.GONE);
                myFalse.setVisibility(View.VISIBLE);
                myTrue.setVisibility(View.GONE);
                manager.beginTransaction().show(fragmentList.get(1)).hide(fragmentList.get(0)).hide(fragmentList.get(2)).commit();
                break;
            case R.id.my:
                myTrue.setVisibility(View.VISIBLE);
                myFalse.setVisibility(View.GONE);
                homeFalse.setVisibility(View.VISIBLE);
                homeTrue.setVisibility(View.GONE);
                cinemaFalse.setVisibility(View.VISIBLE);
                cinemaTrue.setVisibility(View.GONE);
                manager.beginTransaction().show(fragmentList.get(2)).hide(fragmentList.get(1)).hide(fragmentList.get(0)).commit();
                break;
        }
    }
}
