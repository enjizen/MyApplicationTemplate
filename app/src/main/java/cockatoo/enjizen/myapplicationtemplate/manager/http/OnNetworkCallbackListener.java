package cockatoo.enjizen.myapplicationtemplate.manager.http;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by streami.t.mobiledeveloper1 on 2/2/2018 AD.
 */

public interface OnNetworkCallbackListener {

     void onResponse(Object object, Retrofit retrofit);
     void onBodyError(ResponseBody responseBodyError);
     void onBodyErrorIsNull();
     void onFailure(Throwable t);
}
