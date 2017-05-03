package com.yuanxiao.greendao.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Smile on 2017/5/4.
 */
@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;

    private String Username;
    private String Password;
    @Generated(hash = 1597491591)
    public User(Long id, String Username, String Password) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
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
}
