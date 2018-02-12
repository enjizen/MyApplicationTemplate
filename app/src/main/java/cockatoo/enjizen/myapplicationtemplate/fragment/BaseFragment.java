package cockatoo.enjizen.myapplicationtemplate.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import cc.cloudist.acplibrary.ACProgressFlower;
import cockatoo.enjizen.myapplicationtemplate.dialog.AlertDialogFragment;
import cockatoo.enjizen.myapplicationtemplate.dialog.ConfirmDialogFragment;
import cockatoo.enjizen.myapplicationtemplate.manager.http.CallApiServiceManagerListener;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import cockatoo.enjizen.myapplicationtemplate.manager.http.CallApiServiceManager;
import cockatoo.enjizen.myapplicationtemplate.util.DialogUtil;
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
        apiService = new CallApiServiceManager(this,getChildFragmentManager());
    }


    /**
     * Call Api Service Common
     * @return
     */
    public CallApiServiceManager getApiService() {
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

        DialogUtil.getInstance().showAlertDialog(getFragmentManager(),message,positiveButton);

    }

    /**
     * @param message
     * @param positiveButton
     * @param negativeButton
     */
    protected void showAlertConfirmDialog(String message
            ,@StringRes int positiveButton
            ,@StringRes int negativeButton
            ){
        DialogUtil.getInstance().showAlertConfirmDialog(getFragmentManager(),message,positiveButton,negativeButton);

    }

    /**
     * Toast
     * @param msg
     */

    protected void toast(String msg){
        ToastUtil.getInstance().toast(getContext(),msg);
    }

    /**
     *  Long Toast
     * @param msg
     */
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
     *src
     * Api Service Response
     *
     */

    @Override
    public void callbackProvinceModelResponse(ProvinceModel provinceModel) {


    }

    @Override
    public void callbackAmphurModelResponse(AmphurModel amphurModel) {
    }

    @Override
    public void onHideLoadingDialog() {
        hideLoadingDialog();
    }


}
