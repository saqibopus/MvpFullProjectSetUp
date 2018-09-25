package saqib.com.mvpfullprojectsetup.Database.Tables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "user_info")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "birth_date")
    private int birthDate;

    @ColumnInfo(name = "contact_number")
    private String contactNumber;

    public boolean isLoginToken() {
        return loginToken;
    }

    public void setLoginToken(boolean loginToken) {
        this.loginToken = loginToken;
    }

    public boolean isLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(boolean loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }

    @ColumnInfo(name = "u_id")
    private String u_id;

    @ColumnInfo(name = "fcm_id")
    private String fcm_id;

    @ColumnInfo(name = "is_premium")
    private boolean isPremium;

    @ColumnInfo(name = "login_token")
    private boolean loginToken;

    @ColumnInfo(name = "login_time_stamp")
    private boolean loginTimeStamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getFcm_id() {
        return fcm_id;
    }

    public void setFcm_id(String fcm_id) {
        this.fcm_id = fcm_id;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
