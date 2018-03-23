package com.anke.mvpdemo.presenter;

import com.anke.mvpdemo.callback.ITestCallBack;
import com.anke.mvpdemo.model.TestModel;
import com.anke.mvpdemo.view.ITestView;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class TestPresenter {
    private ITestView testView;
    public TestPresenter(ITestView testView){
        this.testView = testView;
    }
    public void showData(String url){
        testView.showDialog();
        TestModel testModel = new TestModel();
        testModel.getDataByserver(url, new ITestCallBack() {
            @Override
            public void success(String data) {
                testView.showData(data);
                testView.hiddenDialog();
            }

            @Override
            public void fail(String data) {
                testView.showFail(data);
                testView.hiddenDialog();
            }
        });
    }
}
