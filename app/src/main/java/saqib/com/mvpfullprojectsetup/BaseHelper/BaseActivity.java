package saqib.com.mvpfullprojectsetup.BaseHelper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    public void startFragment(int holder,Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(holder, fragment);
        ft.addToBackStack("first");
        ft.commit();
    }
}
