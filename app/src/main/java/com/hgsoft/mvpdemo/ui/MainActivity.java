package com.hgsoft.mvpdemo.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hgsoft.mvpdemo.R;
import com.hgsoft.mvpdemo.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainActivityPresenter>{

    @BindView(R.id.textview)
    TextView mTextview;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        findViewById(R.id.button).setOnClickListener(this);
        initFragment();
    }

    private void initFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, new MainFragment());
        fragmentTransaction.commit();
    }

    public void showStudentInfo(String info) {
        mTextview.setText("activity:" + info);
    }

    @OnClick(R.id.button)
    public void onClick(View view) {
        System.out.println("buttonOnclick");
        getPresenter().doSomeThing();
    }

    @Override
    public MainActivityPresenter initPresenter() {
        return new MainActivityPresenter();
    }
}
