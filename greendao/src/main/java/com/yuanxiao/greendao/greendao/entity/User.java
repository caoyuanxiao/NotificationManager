package com.yuanxiao.greendao.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kc on 17/5/9.
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;

    private String Username;
    private String Password;
    private int age;
    private int date;
    @Generated(hash = 1244372227)
    public User(Long id, String Username, String Password, int age, int date) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
        this.age = age;
        this.date = date;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    public String getPassword() {
        return this.Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getDate() {
        return this.date;
    }
    public void setDate(int date) {
        this.date = date;
    }
}
