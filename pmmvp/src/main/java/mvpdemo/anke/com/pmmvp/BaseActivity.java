package mvpdemo.anke.com.pmmvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import mvpdemo.anke.com.pmmvp.view.BaseView;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public abstract class BaseActivity extends RxAppCompatActivity implements BaseView {

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("数据加载中....");

    }

    @Override
    public void hideenDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showDIalog() {
        progressDialog.show();
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
