package com.hgsoft.mvpdemo.model;

/**
 * Created by YUDAPEI on 2017/7/21.
 */

public class Student extends BaseModel {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String studentDesc() {
        return "name=" + name + ",age=" + age;
    }
}
