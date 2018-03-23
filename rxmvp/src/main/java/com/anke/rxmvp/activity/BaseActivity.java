package com.anke.rxmvp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.anke.rxmvp.view.BaseView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class BaseActivity extends RxAppCompatActivity implements BaseView {

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("数据加载中....");
    }

    @Override
    public void showDialog() {
        progressDialog.show();
    }

    @Override
    public void hiddenDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
