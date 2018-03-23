package mvpdemo.anke.com.pmmvp.view;

import android.content.Context;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public interface BaseView {
    void hideenDialog();
    void showDIalog();
    void showErrorMsg(String msg);
    Context getContext();
}
