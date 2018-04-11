package cockatoo.enjizen.myapplicationtemplate.manager.http;



import cockatoo.enjizen.myapplicationtemplate.constanst.Config;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public interface ApiService {

    @GET(Config.contextMasterData +"province")
    Call<ProvinceModel> getProvince(@Query("lang") String lang);

    @GET(Config.contextMasterData +"amphur")
    Call<AmphurModel> getAmphur( @Query("lang") String lang, @Query("provinceId") int province_id);

}
