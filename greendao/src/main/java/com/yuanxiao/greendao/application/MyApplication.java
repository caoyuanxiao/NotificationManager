package com.yuanxiao.greendao.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.yuanxiao.greendao.greendao.DbHelper.MergeOpenHelper;
import com.yuanxiao.greendao.greendao.gen.DaoMaster;
import com.yuanxiao.greendao.greendao.gen.DaoSession;


/**
 * Created by Smile on 2017/5/4.
 */

public class MyApplication extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        //创建数据库shop.db"
        // DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        MergeOpenHelper helper = new MergeOpenHelper(this, "shop.db");
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();


    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
