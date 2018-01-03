package cockatoo.enjizen.myapplicationtemplate.fragment;


import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import cc.cloudist.acplibrary.ACProgressFlower;
import cockatoo.enjizen.myapplicationtemplate.dialog.AlertDialogFragment;
import cockatoo.enjizen.myapplicationtemplate.dialog.ConfirmDialogFragment;

/**
 * Created by Wanchalerm Yuphasuk on 27/12/2017 AD.
 */

public class BaseFragment extends Fragment implements AlertDialogFragment.OnDialogListener
                                                        ,ConfirmDialogFragment.OnDialogListener{


    private ACProgressFlower dialog;

    public void showLoadingDialog() {

            dialog = new ACProgressFlower.Builder(getContext())
                    .build();

            // dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }

    public void hideLoadingDialog(){
        dialog.dismiss();
    }

    public void showAlertDialog(String message
            ,@StringRes int positiveButton){
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .build();

        alertDialogFragment.setCancelable(false);
        alertDialogFragment.show(getChildFragmentManager(),"alert dialog");

    }

    public void showAlertConfirmDialog(String message
            ,@StringRes int positiveButton
            ,@StringRes int NegativeButton
            ){
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .setNegative(NegativeButton)
                .build();

        confirmDialogFragment.setCancelable(false);
        confirmDialogFragment.show(getChildFragmentManager(),"confirm dialog");

    }


    @Override
    public void onPositiveButtonClick() {

    }

    @Override
    public void onNegativeButtonClick() {

    }
}
