package mvpdemo.anke.com.pmmvp.view;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public interface ITestView<T> extends BaseView {
    void showData(T t);
}
