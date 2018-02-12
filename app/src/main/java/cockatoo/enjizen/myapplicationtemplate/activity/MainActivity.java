package cockatoo.enjizen.myapplicationtemplate.activity;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.crash.FirebaseCrash;

import butterknife.ButterKnife;
import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.fragment.MainFragment;
import cockatoo.enjizen.myapplicationtemplate.fragment.ScanQrCodeFragment;
import cockatoo.enjizen.myapplicationtemplate.fragment.YoutubeFragment;
import cockatoo.enjizen.myapplicationtemplate.util.LogUtil;
import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class MainActivity extends BaseActivity implements ScanQrCodeFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseCrash.log("Activity created");

        ButterKnife.bind(this);

        super.setupDrawerLayout();

        if(savedInstanceState == null){
            firstFragment();
        }


    }

    private void firstFragment() {
        onRequestPermissionsResult();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainer, MainFragment.newInstance(),"MainFragment")
                .commit();
    }



    // Check Runtime Permission -- BEGIN
    public void onRequestPermissionsResult() {
        Nammu.init(this);
        // Check Runtime Permission
        Nammu.askForPermission(this, Manifest.permission.CAMERA, new PermissionCallback() {
            @Override
            public void permissionGranted() {

            }

            @Override
            public void permissionRefused() {
                finish();
            }
        });
    }

    @Override
    public void onQrCodeResult(String result) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer, YoutubeFragment.newInstance(result))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

       }
}
