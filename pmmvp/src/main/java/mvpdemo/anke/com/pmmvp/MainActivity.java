package mvpdemo.anke.com.pmmvp;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import mvpdemo.anke.com.mytest.Utils;
import mvpdemo.anke.com.pmmvp.presenter.TestPresenter;
import mvpdemo.anke.com.pmmvp.view.ITestView;

public class MainActivity extends BaseActivity implements ITestView<String> {

    private TestPresenter testPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testPresenter = new TestPresenter();
        testPresenter.attachView(this);
        String hell = Utils.hell();
    }
    public void btn1(View view) {
        testPresenter.showData("1");
        Observable.interval(5, TimeUnit.SECONDS)
               // .compose(this.<Long>bindUntilEvent(ActivityEvent.DESTROY))
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e("11111",aLong.toString());
                    }
                });

    }

    public void btn2(View view) {
        testPresenter.showData("2");
    }


    @Override
    public void showData(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        testPresenter.detachView();
        super.onDestroy();
    }
}
