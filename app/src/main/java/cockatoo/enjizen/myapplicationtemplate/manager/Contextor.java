package cockatoo.enjizen.myapplicationtemplate.manager;

import android.content.Context;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class Contextor {

    private static Contextor instance;

    public static Contextor getInstance() {
        if (instance == null)
            instance = new Contextor();
        return instance;
    }

    private Context mContext;

    private Contextor() {
        
    }

    public void init(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

}
