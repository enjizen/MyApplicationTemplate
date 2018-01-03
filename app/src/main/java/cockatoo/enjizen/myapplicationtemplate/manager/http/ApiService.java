package cockatoo.enjizen.myapplicationtemplate.manager.http;

import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public interface ApiService {

    @GET("masterdata/province")
    Call<ProvinceModel> getProvince(@Query("lang") String lang);

}
