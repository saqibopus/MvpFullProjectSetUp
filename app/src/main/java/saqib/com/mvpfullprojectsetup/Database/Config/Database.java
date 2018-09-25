package saqib.com.mvpfullprojectsetup.Database.Config;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import saqib.com.mvpfullprojectsetup.Database.Crud.CrudUserInfo;
import saqib.com.mvpfullprojectsetup.Database.DAO.UserInfoDao;
import saqib.com.mvpfullprojectsetup.Database.Tables.UserInfo;


@android.arch.persistence.room.Database(
        entities = {UserInfo.class},
        version = 1)
public abstract class Database extends RoomDatabase {

    public abstract UserInfoDao getUserInfoDao();
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public boolean isOpen() {
        return super.isOpen();
    }

    @Override
    public boolean inTransaction() {
        return super.inTransaction();
    }
}
