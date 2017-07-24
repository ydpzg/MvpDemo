package com.hgsoft.mvpdemo.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.hgsoft.mvpdemo.R;
import com.hgsoft.mvpdemo.presenter.MainActivityPresenter;

import butterknife.ButterKnife;


public class MainActivity extends BaseActivity<MainActivityPresenter> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        findViewById(R.id.button).setOnClickListener(this);
        initFragment();
    }

    private void initFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, new MainFragment());
        fragmentTransaction.commit();
    }

    public void showStudentInfo(String info) {
        ((TextView) findViewById(R.id.textview)).setText("activity:" + info);
    }

    @Override
    public void onClick(View view) {
        System.out.println("buttonOnclick");
        getPresenter().doSomeThing();
    }

    @Override
    public MainActivityPresenter initPresenter() {
        return new MainActivityPresenter();
    }
}
