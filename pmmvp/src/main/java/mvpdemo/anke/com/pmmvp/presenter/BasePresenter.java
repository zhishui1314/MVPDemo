package mvpdemo.anke.com.pmmvp.presenter;

import mvpdemo.anke.com.pmmvp.view.BaseView;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class BasePresenter<V extends BaseView> {
    private V view;
    /**
     * 绑定
     */
    public void attachView(V view){
        this.view = view;
    }
    /**
     * 解绑
     */
    public void detachView(){
        view = null;
    }
    /**
     * 是否绑定
     */
    public boolean attachView(){
       return view != null;
    }
    public V getView(){
        return view;
    }
}
