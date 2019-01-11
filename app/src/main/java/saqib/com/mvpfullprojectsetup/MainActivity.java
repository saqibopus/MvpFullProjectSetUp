package saqib.com.mvpfullprojectsetup;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import saqib.com.mvpfullprojectsetup.BaseHelper.BaseActivity;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.FamousPersonalityFrag;
import saqib.com.mvpfullprojectsetup.Modules.Navigation.NavigationFragment;

public class MainActivity extends BaseActivity implements NavigationFragment.OnNavigationItemClick {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_home_img)
    ImageView toolbarHomeImg;
    @BindView(R.id.toolbar_home_title)
    TextView toolbarHomeTitle;
    @BindView(R.id.home_drawer)
    DrawerLayout homeDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpToolbar(mToolbar);
        setUpDrawerFragment();

    }

    private void setUpToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        toolbarHomeTitle.setText("Home Coming");
        toolbarHomeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeDrawer != null) {
                    if (homeDrawer.isDrawerOpen(Gravity.LEFT)) {
                        closeDrawer();
                    } else {
                        openDrawer();
                    }
                }
            }
        });
    }

    private void setUpDrawerFragment() {
        NavigationFragment navigationFragment = new NavigationFragment().setListner(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.home_drawer_fragment, navigationFragment).commit();
    }

    private void openDrawer() {
        if (homeDrawer != null) {
            if (homeDrawer.isDrawerOpen(Gravity.LEFT)) {
                homeDrawer.closeDrawer(Gravity.RIGHT);
            } else {
                homeDrawer.openDrawer(Gravity.LEFT);
            }
        }
    }

    private void closeDrawer() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                if (homeDrawer != null) {
                    homeDrawer.closeDrawer(Gravity.LEFT);
                }
            }
        });

    }


    @Override
    public void onHomeClick() {
        closeDrawer();
        Logs.tL(MainActivity.this, "Home click");
        startFragment(R.id.home_drawer_main, new FamousPersonalityFrag());
    }

    @Override
    public void onFirstClick() {
        closeDrawer();
        Logs.tL(MainActivity.this, "First click");
    }
}
