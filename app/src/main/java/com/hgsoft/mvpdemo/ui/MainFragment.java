package com.hgsoft.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hgsoft.mvpdemo.R;
import com.hgsoft.mvpdemo.presenter.MainFragmentPresenter;

/**
 * Created by YUDAPEI on 2017/7/24.
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements View.OnClickListener {


    @Override
    public MainFragmentPresenter initPresenter() {
        return new MainFragmentPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);
        view.findViewById(R.id.button).setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void showStudentInfo(String info) {
        ((TextView) getView().findViewById(R.id.textview)).setText("fragment:" + info);
    }

    @Override
    public void onClick(View view) {
        System.out.println("buttonOnclick");
        getPresenter().doSomeThing();
    }
}
