package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.aes.EncryptUtil;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.presenter.RegisterPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterPresenterImpl> implements RegisterContract.View {


    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_code)
    EditText registerCode;
    @BindView(R.id.btn_code)
    Button btnCode;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected RegisterPresenterImpl initPresenter() {
        return new RegisterPresenterImpl();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initListener();
    }

    private void initListener() {
       btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name = registerName.getText().toString().trim();
               String email = registerEmail.getText().toString().trim();
               String pwd = registerPwd.getText().toString().trim();
               String code = registerCode.getText().toString().trim();
               String encrypt = EncryptUtil.encrypt(pwd);
               if (!name.isEmpty() && !email.isEmpty() && !pwd.isEmpty() && !code.isEmpty() && !encrypt.isEmpty()){
                   presenter.register(name,email,pwd,code);
               }else{
                   Toast.makeText(RegisterActivity.this, "请填写正确的格式", Toast.LENGTH_SHORT).show();
               }
           }
       });
       /*
        获取验证码
        */
       btnCode.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email = registerEmail.getText().toString().trim();
               if (email!=null){
                   presenter.code(email);
               }
           }
       });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void codeSuccess(Object obj) {
        if (obj instanceof CodeBean){
            CodeBean codeBean = (CodeBean) obj;
            String message = codeBean.getMessage();
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void codeFilter(String msg) {

    }

    @Override
    public void registerSuccess(Object obj) {
        if (obj instanceof RegisterBean){
            RegisterBean registerBean = (RegisterBean) obj;
            String message = registerBean.getMessage();
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        }
    }

    @Override
    public void registerFilter(String msg) {

    }


}
