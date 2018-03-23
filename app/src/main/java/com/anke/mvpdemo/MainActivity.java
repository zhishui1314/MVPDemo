package com.anke.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.anke.mvpdemo.presenter.TestPresenter;
import com.anke.mvpdemo.view.ITestView;

public class MainActivity extends AppCompatActivity implements ITestView {

    private ProgressDialog progressDialog;
    private TestPresenter testPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testPresenter = new TestPresenter(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("数据加载中....");
    }

    public void btn1(View view) {
        testPresenter.showData("1");
    }

    public void btn2(View view) {
        testPresenter.showData("2");
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
    public void showData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFail(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
