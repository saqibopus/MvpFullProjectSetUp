package saqib.com.mvpfullprojectsetup.Database.Crud;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;
import saqib.com.mvpfullprojectsetup.Database.Config.Database;
import saqib.com.mvpfullprojectsetup.Database.Tables.UserInfo;
import saqib.com.mvpfullprojectsetup.Helpers.AppConstant;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Helpers.ProgressHelper;

public class CrudUserInfo {

    private Database database;
    private Activity activity;
    private ProgressHelper progressHelper;

    public CrudUserInfo(Activity activity) {
        this.activity = activity;
        initProgress();
        initDatabase();
    }

    private void initProgress(){
        progressHelper = ProgressHelper.getInstance();
        progressHelper.initProgressDilog(activity);
    }
    private void initDatabase(){
        database = Room.databaseBuilder(activity, Database.class, AppConstant.DB.DB_NAME)
                .allowMainThreadQueries().build();
    }

    private void setSession(UserInfo userInfo){
        if(database.isOpen()){
            insertUser(userInfo);
        }else {
            Logs.p("Database is not open");
        }
    }

    private UserInfo getSession(){
        return null;
    }

    private void removeSession(){

    }


    public void insertUser(final UserInfo user){

        new AsyncTask<Void, Void, Void>() {
            long id = -1;
            @Override
            protected Void doInBackground(Void... voids) {
                id = database.getUserInfoDao().insertUser(user);
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressHelper.show("Inserting User");
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                progressHelper.dissmiss();
            }
        }.execute();
    }

    public void getUsers() {
        new AsyncTask<Void, Void, Void>() {
            List<UserInfo> users = new ArrayList<>();
            @Override
            protected Void doInBackground(Void... params) {
                users = database.getUserInfoDao().getAllUser();
                if(database.isOpen()){

                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressHelper.show("Getting User");
            }

            @Override
            protected void onPostExecute(Void notes) {
                progressHelper.dissmiss();
            }
        }.execute();

    }
}
