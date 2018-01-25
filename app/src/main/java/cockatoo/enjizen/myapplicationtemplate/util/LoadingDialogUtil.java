package cockatoo.enjizen.myapplicationtemplate.util;

import android.content.Context;

import cc.cloudist.acplibrary.ACProgressFlower;
import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class LoadingDialogUtil {

    private static LoadingDialogUtil instance;

    private ACProgressFlower dialog;

    public static LoadingDialogUtil getInstance() {
        if (instance == null)
            instance = new LoadingDialogUtil();
        return instance;
    }

    private LoadingDialogUtil() {}


    public void showLoadingDialog(Context context) {
        if(dialog == null) {
            dialog = new ACProgressFlower.Builder(context)
                    .build();

            // dialog.setCanceledOnTouchOutside(false);

        }
        dialog.show();
    }

    public void hideLoadingDialog(){
        dialog.dismiss();
    }



}
