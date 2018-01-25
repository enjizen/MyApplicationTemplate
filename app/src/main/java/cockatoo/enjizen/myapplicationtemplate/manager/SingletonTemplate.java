package cockatoo.enjizen.myapplicationtemplate.manager;

import android.content.Context;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class SingletonTemplate {

    private static SingletonTemplate instance;

    public static SingletonTemplate getInstance() {
        if (instance == null)
            instance = new SingletonTemplate();
        return instance;
    }

    private Context mContext;

    private SingletonTemplate() {
        mContext = Contextor.getInstance().getContext();
    }

}
