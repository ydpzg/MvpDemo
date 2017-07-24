package com.hgsoft.mvpdemo.presenter;

import android.os.Bundle;

import com.hgsoft.mvpdemo.model.Student;
import com.hgsoft.mvpdemo.ui.MainActivity;

/**
 * Created by YUDAPEI on 2017/7/21.
 */

public class MainActivityPresenter extends BasePresenter<MainActivity> {

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
