package com.anke.mvpdemo.model;

import com.anke.mvpdemo.callback.ITestCallBack;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public interface ITestModel {
    void getDataByserver(String url, ITestCallBack testCallBack);
}
