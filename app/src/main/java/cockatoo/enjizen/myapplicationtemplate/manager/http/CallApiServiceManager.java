package cockatoo.enjizen.myapplicationtemplate.manager.http;

import android.content.Context;
import android.support.annotation.NonNull;


import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
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
     * @param listener
     */
    public CallApiServiceManager(CallApiServiceManagerListener listener){
        this.context = Contextor.getInstance().getContext();
        this.mListener = listener;
        this.apiService = HttpManager.getInstance().getService();
    }

    public void getProvince(){
        apiService.getProvince(context.getResources().getString(R.string.local_upper)).enqueue(new Callback<ProvinceModel>() {
            @Override
            public void onResponse(@NonNull Call<ProvinceModel> call, @NonNull Response<ProvinceModel> response) {
                if (response.isSuccessful()){
                    mListener.provinceResponse(response.body());
                }
                else{
                    ProvinceModel provinceModel = new ProvinceModel();
                    provinceModel.setMessageCode(response.code());
                    provinceModel.setMessageDetail(response.message());
                    mListener.provinceResponse(provinceModel);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProvinceModel> call, @NonNull Throwable t) {
                ProvinceModel provinceModel = new ProvinceModel();
                provinceModel.setMessageCode(0);
                provinceModel.setMessageDetail(context.getString(R.string.session_time_out));
                mListener.provinceResponse(provinceModel);
            }
        });
    }

    public void getAmphur(int provinceId){
        apiService.getAmphur(context.getResources().getString(R.string.local_upper),provinceId).enqueue(new Callback<AmphurModel>() {
            @Override
            public void onResponse(@NonNull Call<AmphurModel> call, Response<AmphurModel> response) {
                if(response.isSuccessful()){
                    mListener.amphurResponse(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AmphurModel> call, Throwable t) {

            }
        });
    }


}
