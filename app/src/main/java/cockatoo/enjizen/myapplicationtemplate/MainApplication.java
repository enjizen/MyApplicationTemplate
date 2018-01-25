package cockatoo.enjizen.myapplicationtemplate;

import android.app.Application;

import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
