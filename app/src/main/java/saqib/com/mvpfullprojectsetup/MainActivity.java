package saqib.com.mvpfullprojectsetup;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Modules.Navigation.NavigationFragment;
import saqib.com.mvpfullprojectsetup.Modules.Navigation.NavigationModel;

public class MainActivity extends AppCompatActivity implements NavigationFragment.OnNavigationItemClick{

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
                    if (homeDrawer.isDrawerOpen(GravityCompat.START)) {
                        closeDrawer();
                    } else {
                        openDrawer();
                    }
                }
            }
        });
    }

    private void setUpDrawerFragment(){

        NavigationFragment navigationFragment = new NavigationFragment().setListner(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.home_drawer_fragment,navigationFragment).commit();

    }

    private void openDrawer() {
        if (homeDrawer != null) {
            if (homeDrawer.isDrawerOpen(GravityCompat.START)) {
                homeDrawer.openDrawer(GravityCompat.END);
            } else {
                homeDrawer.openDrawer(GravityCompat.START);
            }
        }
    }

    private void closeDrawer() {
        if (homeDrawer != null) {
            homeDrawer.openDrawer(GravityCompat.END);
        }
    }

    @Override
    public void onNavigationItem(Integer model) {
        Logs.tL(MainActivity.this,String.valueOf(model));
    }
}
