package com.bw.movie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.aes.EncryptUtil;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.View {
    @BindView(R.id.login_email)
    EditText loginEmail;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.text_register)
    TextView textRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @Override
    protected LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initListener();

    }
    private void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this, "请输入邮箱和密码", Toast.LENGTH_SHORT).show();
                }else{
                    String encrypt = EncryptUtil.encrypt(pwd);
                    presenter.login(email,encrypt);
                }
            }
        });
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof LoginBean){
            LoginBean loginBean = (LoginBean) obj;
            SharedPreferences sp = App.context.getSharedPreferences("config", MODE_PRIVATE);
            sp.edit().putInt("userId",loginBean.getResult().getUserId());
            sp.edit().putString("sessionId",loginBean.getResult().getSessionId());
            sp.edit().commit();
            if (loginBean.getStatus().equals("0000")){
                Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void filter(String msg) {

    }


}
