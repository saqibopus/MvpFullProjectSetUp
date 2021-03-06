package saqib.com.mvpfullprojectsetup.Helpers;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;


/**
 * Created by emxcel on 13/9/18.
 */

public class Logs {

    public static void p(String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            System.out.println(AppConstant.LOG_LEVEL.APP_TAG+" : "+message);
    }
    public static void d(String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            Log.d(AppConstant.LOG_LEVEL.APP_TAG," : "+message);
    }
    public static void e(String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            Log.e(AppConstant.LOG_LEVEL.APP_TAG," : "+message);
    }

    public static void tS(Context c,String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }
    public static void tS(Activity c, String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }
    public static void tL(Context c,String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }
    public static void tL(Activity c, String message){
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }
    public static void pClass(Object message){
        Gson gson = new Gson();
        if(AppConstant.LOG_LEVEL.SHOW_LOGS)
            System.out.println(AppConstant.LOG_LEVEL.APP_TAG+" : "+message);
    }
}
