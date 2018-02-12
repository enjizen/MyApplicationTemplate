package cockatoo.enjizen.myapplicationtemplate.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.fragment.ScanQrCodeFragment;
import cockatoo.enjizen.myapplicationtemplate.fragment.YoutubeFragment;

/**
 * Created by Wanchalerm on 12/2/2018 AD.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nvView)
    NavigationView navigationView;

    @BindView(R.id.btnHamburger)
    AppCompatImageButton btnHamburger;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    private Class<YoutubeFragment> fragmentClass;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    protected void setupDrawerLayout() {
       setSupportActionBar(toolbar);

        setupDrawerContent();
        setClickListener();
    }

    private void setClickListener() {
        btnHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
    }



    private void setupDrawerContent() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }


    private void selectDrawerItem(MenuItem item) {
        Class fragmentClass = null;
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_scan_qr_code:
                fragmentClass = ScanQrCodeFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentContainer,fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

}
