package cockatoo.enjizen.myapplicationtemplate.manager.http;

import android.content.Context;

import java.io.IOException;

import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.manager.Contextor;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import cockatoo.enjizen.myapplicationtemplate.util.LogUtil;
import retrofit2.Call;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class CallApiServiceManager {

    private static CallApiServiceManager instance;
    private static final String TAG = "CallApi";


    public static CallApiServiceManager getInstance() {
        if (instance == null)
            instance = new CallApiServiceManager();
        return instance;
    }

    private Context mContext;

    private CallApiServiceManager() {
        mContext = Contextor.getInstance().getContext();
    }


    public ProvinceModel getProvince() {
        Call<ProvinceModel> call = HttpManager.getInstance().getService().getProvince(mContext.getString(R.string.local_upper));
        LogUtil.getInstance().i(TAG,"Url Result = " + call.request().url().toString());
        try {
            ProvinceModel provinceModelResponse = call.execute().body();
            return provinceModelResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }



}
