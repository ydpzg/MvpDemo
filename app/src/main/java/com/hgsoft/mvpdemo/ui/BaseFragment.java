package com.hgsoft.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hgsoft.mvpdemo.presenter.BasePresenter;

/**
 * Created by YUDAPEI on 2017/7/21.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    private T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = initPresenter();

    }

    public abstract T initPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BasePresenter)mPresenter).onAttach(this);
        ((BasePresenter)mPresenter).onCreate(savedInstanceState);
    }

    protected T getPresenter() {
        return mPresenter;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
