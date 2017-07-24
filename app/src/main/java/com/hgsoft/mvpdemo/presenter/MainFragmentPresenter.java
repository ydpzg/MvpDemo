package com.hgsoft.mvpdemo.presenter;

import android.os.Bundle;

import com.hgsoft.mvpdemo.model.Student;
import com.hgsoft.mvpdemo.ui.MainFragment;

/**
 * Created by YUDAPEI on 2017/7/24.
 */

public class MainFragmentPresenter extends BasePresenter<MainFragment> {

    private Student student;

    public void doSomeThing() {
        System.out.println("doSomeThing");
        student = new Student("Tom", 19);
        getView().showStudentInfo(student.studentDesc());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }
}
