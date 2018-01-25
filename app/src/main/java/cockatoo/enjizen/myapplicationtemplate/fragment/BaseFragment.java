package cockatoo.enjizen.myapplicationtemplate.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import cc.cloudist.acplibrary.ACProgressFlower;
import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.dialog.AlertDialogFragment;
import cockatoo.enjizen.myapplicationtemplate.dialog.ConfirmDialogFragment;
import cockatoo.enjizen.myapplicationtemplate.manager.http.CallApiServiceManagerListener;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import cockatoo.enjizen.myapplicationtemplate.manager.http.CallApiServiceManager;
import cockatoo.enjizen.myapplicationtemplate.util.ToastUtil;

/**
 * Created by Wanchalerm Yuphasuk on 27/12/2017 AD.
 */

public class BaseFragment extends Fragment implements CallApiServiceManagerListener
                                                        ,AlertDialogFragment.OnDialogListener
                                                        ,ConfirmDialogFragment.OnDialogListener{


    private ACProgressFlower dialog;
    private CallApiServiceManager apiService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = new CallApiServiceManager(this);
    }

    /**
     * Call Api Service Common
     * @return
     */
    public CallApiServiceManager getApiServicePresenter() {
        showLoadingDialog();
        return apiService;
    }

    /**
     * Show Loading Wait Api or Other
     */
    public void showLoadingDialog() {

            dialog = new ACProgressFlower.Builder(getContext())
                    .build();

            // dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }


    /**
     * Hide Loading Wait Api or Other
     */

    protected void hideLoadingDialog(){
        dialog.dismiss();
    }

    /**
     * @param message
     * @param positiveButton
     */

    protected void showAlertDialog(String message
            ,@StringRes int positiveButton){
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .build();

        alertDialogFragment.setCancelable(false);
        alertDialogFragment.show(getChildFragmentManager(),"alert dialog");

    }

    /**
     * @param message
     * @param positiveButton
     * @param NegativeButton
     */
    protected void showAlertConfirmDialog(String message
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

    protected void toast(String msg){
        ToastUtil.getInstance().toast(getContext(),msg);
    }

    protected void toastLong(String msg){
        ToastUtil.getInstance().toastLong(getContext(),msg);
    }

    /**
     * Override Confirm Dialog
     */

    @Override
    public void onPositiveButtonClick() {

    }

    @Override
    public void onNegativeButtonClick() {

    }



    /**
     *
     * Api Service Response
     *
     */

    @Override
    public void provinceResponse(ProvinceModel provinceModel) {
        hideLoadingDialog();

        if(provinceModel.getMessageCode() != null){
            showAlertDialog(provinceModel.getMessageDetail(), R.string.ok);
        }

    }

    @Override
    public void amphurResponse(AmphurModel amphurModel) {
        hideLoadingDialog();

        if(amphurModel.getMessageCode() != null){
            showAlertDialog(amphurModel.getMessageDetail(), R.string.ok);
        }
    }
}
