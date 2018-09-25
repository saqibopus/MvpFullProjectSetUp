package saqib.com.mvpfullprojectsetup.Modules.Authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import saqib.com.mvpfullprojectsetup.R;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        //Login & SignUp & Forgot Password would be fragments
    }
}
