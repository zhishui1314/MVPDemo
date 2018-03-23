package com.anke.rxmvp.presenter;

import com.anke.rxmvp.view.BaseView;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class BasePresenter<V extends BaseView> {
    private V view;


    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public boolean isAttachView() {
        return view != null;
    }
    public V getView(){
        return view;
    }

}
