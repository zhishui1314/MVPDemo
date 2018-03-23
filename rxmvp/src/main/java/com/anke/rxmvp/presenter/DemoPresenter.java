package com.anke.rxmvp.presenter;

import com.anke.rxmvp.bean.Student;
import com.anke.rxmvp.calback.BaseCallBack;
import com.anke.rxmvp.model.DemoModel;
import com.anke.rxmvp.view.DemoView;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class DemoPresenter extends BasePresenter<DemoView> {

    private final DemoModel demoModel;

    public DemoPresenter(LifecycleTransformer objectLifecycleTransformer) {
        demoModel = new DemoModel(objectLifecycleTransformer);
    }

    public void showData(String url) {
        if (getView() == null) {
            return;
        }
        getView().showDialog();
        demoModel.getDataByServer(url, new BaseCallBack<Student>() {
            @Override
            public void success(Student data) {
                getView().hiddenDialog();
                getView().showData(data);
            }

            @Override
            public void fial(String msg) {
                getView().hiddenDialog();
                getView().showErrorMsg(msg);
            }
        });
    }
}
