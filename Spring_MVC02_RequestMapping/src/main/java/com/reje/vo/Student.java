package com.reje.vo;
//保存请求参数的对象
public class Student {
    //属性名和请求参数中的名字一样
    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student的无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
