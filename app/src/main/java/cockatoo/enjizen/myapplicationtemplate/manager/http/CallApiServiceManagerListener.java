package cockatoo.enjizen.myapplicationtemplate.manager.http;

import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by wanchalermyuphasuk on 26/1/2018 AD.
 */

public interface CallApiServiceManagerListener {

    void callbackProvinceModelResponse(ProvinceModel provinceModel);
    void callbackAmphurModelResponse(AmphurModel amphurModel);

    void onHideLoadingDialog();
}
