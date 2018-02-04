package cockatoo.enjizen.myapplicationtemplate.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;

import cockatoo.enjizen.myapplicationtemplate.dialog.AlertDialogFragment;
import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class DialogUtil {

    private static DialogUtil instance;

    public static DialogUtil getInstance() {
        if (instance == null)
            instance = new DialogUtil();
        return instance;
    }

    private Context mContext;

    private DialogUtil() {
        mContext = Contextor.getInstance().getContext();
    }


    public void showAlertDialog(FragmentManager fragmentManager, String message
            , @StringRes int positiveButton){
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .build();

        alertDialogFragment.setCancelable(false);
        alertDialogFragment.show(fragmentManager,"alert dialog");

    }

}
