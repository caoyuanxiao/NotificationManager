package com.yuanxiao.greendao.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Smile on 2017/5/7.
 */

@Entity
public class Person {
    @Id
    Long id;
    String age;
    @Generated(hash = 1579615456)
    public Person(Long id, String age) {
        this.id = id;
        this.age = age;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
