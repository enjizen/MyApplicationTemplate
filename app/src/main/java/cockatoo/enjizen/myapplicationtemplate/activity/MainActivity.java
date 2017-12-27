package cockatoo.enjizen.myapplicationtemplate.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.fragment.MainFragment;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                                        .add(R.id.content_container, MainFragment.newInstance())
                                        .commit();
        }

    }
}
