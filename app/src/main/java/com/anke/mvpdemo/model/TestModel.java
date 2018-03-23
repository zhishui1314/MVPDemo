package com.anke.mvpdemo.model;

import android.os.Handler;
import android.os.Message;

import com.anke.mvpdemo.callback.ITestCallBack;


/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class TestModel implements ITestModel {
    ITestCallBack testCallBack;
android.os.Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        if (msg.what == 1){
            testCallBack.success("成功");
        }else if (msg.what == 2){
            testCallBack.fail("失败");
        }
    }
};
    @Override
    public void getDataByserver(String url, ITestCallBack testCallBack) {
        this.testCallBack = testCallBack;
        switch (url){
            case "1":
                handler.sendEmptyMessageDelayed(1,2000);

                break;
            case "2":
                handler.sendEmptyMessageDelayed(2,2000);

                break;
        }
    }
}
