package com.anke.rxmvp.calback;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public interface BaseCallBack<T> {
    void success(T data);
    void fial(String msg);
}
