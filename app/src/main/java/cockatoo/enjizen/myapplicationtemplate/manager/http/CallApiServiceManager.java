package cockatoo.enjizen.myapplicationtemplate.manager.http;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import cockatoo.enjizen.myapplicationtemplate.util.DialogUtil;
import cockatoo.enjizen.myapplicationtemplate.util.LoadingDialogUtil;
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

    private final FragmentManager fragmentManager;


    /**
     * @param listener
     */
    public CallApiServiceManager(CallApiServiceManagerListener listener, FragmentManager fragmentManager) {
        this.context = Contextor.getInstance().getContext();
        this.mListener = listener;
        this.apiService = HttpManager.getInstance().getService();
        this.fragmentManager = fragmentManager;
    }


    public void getProvince() {
        Call<ProvinceModel> call = apiService.getProvince(context.getResources().getString(R.string.local_upper));
        call.enqueue(new Callback<ProvinceModel>() {
            @Override
            public void onResponse(@NonNull Call<ProvinceModel> call, @NonNull Response<ProvinceModel> response) {
                if (response.isSuccessful()) {
                    hideLoadingDialog();
                    mListener.provinceResponse(response.body());
                } else {
                    onError();
                }

            }

            @Override
            public void onFailure(@NonNull Call<ProvinceModel> call, @NonNull Throwable t) {
                onError();
            }
        });
    }


    public void getAmphur(int provinceId) {
        apiService.getAmphur(context.getResources().getString(R.string.local_upper), provinceId).enqueue(new Callback<AmphurModel>() {
            @Override
            public void onResponse(@NonNull Call<AmphurModel> call, Response<AmphurModel> response) {
                if (response.isSuccessful()) {
                    mListener.amphurResponse(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AmphurModel> call, Throwable t) {

            }
        });
    }


    private void validateCode(Object object) {

    }

    private void onError(){
         hideLoadingDialog();
         showAlertDialog();
    }

    private void hideLoadingDialog(){
        mListener.onHideLoadingDialog();
    }


    private void showAlertDialog() {
        DialogUtil.getInstance().showAlertDialog(fragmentManager, "aaaaaaa", R.string.ok);
    }


}
