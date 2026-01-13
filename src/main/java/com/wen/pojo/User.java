package com.wen.pojo;

public class User {
    private String name;
    private Integer age;
    private Adderss adderss;

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

    public Adderss getAdderss() {
        return adderss;
    }

    public void setAdderss(Adderss adderss) {
        this.adderss = adderss;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adderss=" + adderss +
                '}';
    }
}
