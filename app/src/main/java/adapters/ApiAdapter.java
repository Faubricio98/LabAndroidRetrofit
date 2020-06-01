package adapters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    public static ApiService myApiCountries;
    public static ApiService myApiCountry;

    public static ApiService getAPICountriesList(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "https://api.covid19api.com/countries";

        if(myApiCountries == null){
            Retrofit myRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            myApiCountries = myRetrofit.create(ApiService.class);
        }

        return myApiCountries;
    }

    public static ApiService getAPICountry(String countryName){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //https://api.covid19api.com/country/south-africa/status/confirmed?from=2020-03-01T00:00:00Z&to=2020-04-01T00:00:00Z
        Date today = new Date();
        Date yesterday = new Date(today.getTime() + TimeUnit.DAYS.toMillis( -1 ));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String myDate = dateFormat.format(today);
        String myLastDate = dateFormat.format(yesterday);
        String baseUrl = "https://api.covid19api.com/country/"+countryName+"/status/confirmed?from="+myLastDate+"T00:00:00Z&to="+myDate+"T00:00:00Z";

        if(myApiCountry == null){
            Retrofit myRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            myApiCountry = myRetrofit.create(ApiService.class);
        }

        return myApiCountry;
    }
}
