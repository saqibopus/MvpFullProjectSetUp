package saqib.com.mvpfullprojectsetup.Database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;
import saqib.com.mvpfullprojectsetup.Database.Tables.UserInfo;


@Dao
public interface UserInfoDao {

    @Insert
    long insertUser(UserInfo userInfo);

    @Query("UPDATE user_info SET name = :new_user_name WHERE name = :old_user_name")
    int updateUserName(String  old_user_name,String new_user_name);

    @Update
    int updateUser(UserInfo userInfo);

    @Query("SELECT * FROM user_info")
    List<UserInfo> getAllUser();


    @Delete
    int deleteUsers(UserInfo userInfo);

    @Query("DELETE FROM user_info")
    void nukeTable();

}
