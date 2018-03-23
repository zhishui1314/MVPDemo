package com.anke.rxmvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.anke.rxmvp.R;
import com.anke.rxmvp.bean.Student;
import com.anke.rxmvp.presenter.DemoPresenter;
import com.anke.rxmvp.view.BaseView;
import com.anke.rxmvp.view.DemoView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity implements DemoView<Student> {

    private DemoPresenter demoPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LifecycleTransformer objectLifecycleTransformer = this.<Student>bindUntilEvent(ActivityEvent.DESTROY);
        demoPresenter = new DemoPresenter(objectLifecycleTransformer);
        demoPresenter.attachView(this);

    }
    public void btn1(View view) {
        demoPresenter.showData("2");
    }
    public void btn2(View view) {
        Observable.interval(1, TimeUnit.MINUTES)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("1111",aLong.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    protected void onDestroy() {
        demoPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showData(Student data) {
        Log.e("姓名：",data.getName());
       // Toast.makeText(this, "姓名：" + data.getName(), Toast.LENGTH_SHORT).show();
    }
}
