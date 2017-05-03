package com.yuanxiao.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yuanxiao.greendao.application.MyApplication;
import com.yuanxiao.greendao.greendao.DaoSession;
import com.yuanxiao.greendao.greendao.User;
import com.yuanxiao.greendao.greendao.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaoSession daoInstant = MyApplication.getDaoInstant();
        userDao = daoInstant.getUserDao();

        findViewById(R.id.query_user).setOnClickListener(this);
        findViewById(R.id.insert_user).setOnClickListener(this);
        findViewById(R.id.delete_user).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_user:
                userDao.insertOrReplace(new User(Long.parseLong("1"),"123", "1234"));
                userDao.insertOrReplace(new User(Long.parseLong("2"),"1234", "1234"));
                userDao.insertOrReplace(new User(Long.parseLong("3"),"123", "1234567"));
                break;
            case R.id.query_user:
                List<User> list = userDao.queryBuilder().where(UserDao.Properties.Username.eq("123")).list();
                for (User user : list) {
                    System.out.println(user.toString());
                }
                break;
            case R.id.delete_user:
                userDao.deleteByKey(Long.parseLong("1"));
                break;
        }
    }
}
