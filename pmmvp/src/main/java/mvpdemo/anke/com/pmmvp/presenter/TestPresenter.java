package mvpdemo.anke.com.pmmvp.presenter;

import mvpdemo.anke.com.pmmvp.callback.ITestCallBack;
import mvpdemo.anke.com.pmmvp.model.TestModel;
import mvpdemo.anke.com.pmmvp.view.ITestView;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class TestPresenter extends BasePresenter<ITestView<String>> {

    public void showData(String url) {

        if (!attachView()) {
            return;
        }
        getView().showDIalog();
        TestModel testModel = new TestModel();
        testModel.getDataByserver(url, new ITestCallBack() {
            @Override
            public void success(String data) {
                if (getView() != null) {
                    getView().hideenDialog();
                    getView().showData(data);
                }
            }

            @Override
            public void fail(String data) {
                if (getView() != null) {
                    getView().hideenDialog();
                    getView().showErrorMsg(data);
                }
            }
        });
    }
}
