package com.quark.cloud.entity;

/**
 * Created by ZhenpengLu on 2017/9/30.
 */
public class UserEntity {

    private String name;
    private String age;

    public UserEntity() {
    }

    public UserEntity(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
