package cockatoo.enjizen.myapplicationtemplate.manager.http;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import cockatoo.enjizen.myapplicationtemplate.util.DialogUtil;
import cockatoo.enjizen.myapplicationtemplate.util.InvalidCode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wanchalerm Yuphasuk on 17/1/2018 AD.
 */

public class CallApiServiceManager {

    /**
     * Context Activity
     */
    private final Context context;

    /**
     * Listener return result
     */
    private final CallApiServiceManagerListener mListener;

    /**
     * Call Api Service
     */
    private final ApiService apiService;

    /**
     * Fragment manager
     */
    private final FragmentManager fragmentManager;


    /**
     * Construct
     * @param listener
     * @param fragmentManager
     */
    public CallApiServiceManager(CallApiServiceManagerListener listener, FragmentManager fragmentManager) {
        this.context = Contextor.getInstance().getContext();
        this.mListener = listener;
        this.apiService = HttpManager.getInstance().getService();
        this.fragmentManager = fragmentManager;
    }

    /**
     * Get Province Api Service
     */

    public void getProvince() {
        Call<ProvinceModel> call = apiService.getProvince(context.getResources().getString(R.string.local_upper));
        call.enqueue(new Callback<ProvinceModel>() {
            @Override
            public void onResponse(@NonNull Call<ProvinceModel> call, @NonNull Response<ProvinceModel> response) {
                if (response.isSuccessful()) {
                    hideLoadingDialog();
                    mListener.callbackProvinceModelResponse(response.body());
                } else {
                    onErrorService(response);
                }




            }

            @Override
            public void onFailure(@NonNull Call<ProvinceModel> call, @NonNull Throwable t) {
                onErrorFailure();
            }
        });

    }




    public void getAmphur(int provinceId) {
        apiService.getAmphur(context.getResources().getString(R.string.local_upper), provinceId).enqueue(new Callback<AmphurModel>() {
            @Override
            public void onResponse(@NonNull Call<AmphurModel> call, Response<AmphurModel> response) {
                if (response.isSuccessful()) {
                    hideLoadingDialog();
                    mListener.callbackAmphurModelResponse(response.body());
                }
                else{
                    onErrorService(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AmphurModel> call, Throwable t) {

            }
        });
    }


    private void onErrorService(Response response) {

        hideLoadingDialog();
        showAlertDialog(InvalidCode.getInstance().invalidHttpStatusCode(response.code()));
    }


    private void onErrorFailure(){

       // FirebaseCrash.logcat(Log.ERROR, methodName, msg);

         hideLoadingDialog();
         showAlertDialog("Please Check Internet Connection");
    }



    private void hideLoadingDialog(){
        mListener.onHideLoadingDialog();
    }


    private void showAlertDialog(String message) {
        DialogUtil.getInstance().showAlertDialog(fragmentManager, message, R.string.ok);
    }


}
