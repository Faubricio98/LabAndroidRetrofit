package adapters;

import java.util.List;

import models.Country;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("Country")
    Call<List<Country>> getCountries();
}
