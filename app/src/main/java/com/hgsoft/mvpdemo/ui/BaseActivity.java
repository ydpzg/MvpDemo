package com.hgsoft.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hgsoft.mvpdemo.presenter.BasePresenter;


/**
 * Created by YUDAPEI on 2017/7/21.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        //先做了Activity的onCreateBeforePresenter再做presenter的Oncreate,最后回到Activity的onCreate
        ((BasePresenter)mPresenter).onAttach(this);
        onCreateBeforePresenter(savedInstanceState);
        ((BasePresenter)mPresenter).onCreate(savedInstanceState);
    }

    private void onCreateBeforePresenter(Bundle savedInstanceState) {

    }

    public abstract T initPresenter();

    protected T getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter.onDetach();
    }
}
