package com.yuanxiao.greendao.greendao.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yuanxiao.greendao.greendao.gen.DaoMaster;
import com.yuanxiao.greendao.greendao.gen.PersonDao;
import com.yuanxiao.greendao.greendao.gen.UserDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Smile on 2017/5/7.
 */

public class MergeOpenHelper extends DaoMaster.OpenHelper {
    public MergeOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MergeOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);
        MigrationHelper.getInstance().migrate(db, UserDao.class, PersonDao.class);
    }
}
