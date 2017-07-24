package com.hgsoft.mvpdemo.presenter;

import android.os.Bundle;

/**
 * Created by YUDAPEI on 2017/7/21.
 */

public abstract class BasePresenter<T> {
    protected T mView;

    public void onAttach(T view) {
        mView = view;
    }

    public void onDetach() {
        mView = null;
    }

    protected T getView() {
        return mView;
    }

    public abstract void onCreate(Bundle savedInstanceState);

    public void onDestroy(){

    }

}
