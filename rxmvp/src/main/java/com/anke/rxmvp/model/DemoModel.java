package com.anke.rxmvp.model;

import com.anke.rxmvp.bean.Student;
import com.anke.rxmvp.calback.BaseCallBack;
import com.anke.rxmvp.view.BaseView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class DemoModel {
    LifecycleTransformer objectLifecycleTransformer;
    public DemoModel(LifecycleTransformer objectLifecycleTransformer) {
        this.objectLifecycleTransformer = objectLifecycleTransformer;
    }
    public void getDataByServer(String url, final BaseCallBack<Student> callBack){
        Observable.interval(2, TimeUnit.SECONDS)
                .compose(objectLifecycleTransformer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Object o) {
                        Student student = new Student();
                        student.setName("张三");
                        student.setSex("11");
                        callBack.success(student);
                    }

                    @Override
                    public void onError(Throwable e) {
                         callBack.fial("失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
