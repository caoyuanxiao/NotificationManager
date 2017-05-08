package com.yuanxiao.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yuanxiao.greendao.application.MyApplication;
import com.yuanxiao.greendao.greendao.entity.User;
import com.yuanxiao.greendao.greendao.gen.DaoSession;
import com.yuanxiao.greendao.greendao.gen.UserDao;

import java.util.ArrayList;
import java.util.HashSet;
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
                // userDao.insertOrReplace(new User(Long.parseLong("1"),"123", "1234"));
                //userDao.insertOrReplace(new User(Long.parseLong("2"),"1234", "1234"));
                // userDao.insertOrReplace(new User(Long.parseLong("3"),"123", "1234567"));
                HashSet<User> mSet = new HashSet<>();
                mSet.add(new User(Long.parseLong("1"), "123", "1234",1,1));
                mSet.add(new User(Long.parseLong("2"), "1234", "1234",2,1));
                mSet.add(new User(Long.parseLong("3"), "12345", "12345",3,1));
                userDao.insertOrReplaceInTx(mSet);

                List<User> users = new ArrayList<>();
                users.add(new User(Long.parseLong("4"), "123", "123456",4,1));
                users.add(new User(Long.parseLong("5"), "123", "1234",5,1));
                userDao.insertOrReplaceInTx(users);

                break;
            case R.id.query_user:
                //List<User> list = userDao.queryBuilder().where(UserDao.Properties.Username.eq("123")).list();


                //查询所有的
                // List<User> list = userDao.queryBuilder().list();


                //   List<User> list = userDao.queryBuilder().where(UserDao.Properties.Username.like("%" + "1234" + "%")).list();
                List<User> list = userDao.queryBuilder().where(UserDao.Properties.Username.eq("123"), UserDao.Properties.Password.eq("1234")).orderDesc(UserDao.Properties.Id).list();

                for (User user : list) {
                    System.out.println("查询数据库："+user.toString());
                }

                List<User> user1 = userDao.queryBuilder().orderDesc(UserDao.Properties.Id).list();
                for (User user : user1) {
                    System.out.println("倒序查询：" + user.toString());
                }
                break;
            case R.id.delete_user:
                userDao.deleteByKey(Long.parseLong("1"));
                break;


        }
    }
}
