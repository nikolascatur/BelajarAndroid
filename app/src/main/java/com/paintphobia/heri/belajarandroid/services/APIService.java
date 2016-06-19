package com.paintphobia.heri.belajarandroid.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by heri on 6/10/2016.
 */
public interface APIService {

    @GET("/{location}/{times}/{date}/{daylight}/{method}.json?key=e39771078e19b5b45c131e34bd367a2d")
    Call<PrayTimesResponse> requestPrayTimes(@Path("location") String location,
                                             @Path("times") String times,
                                             @Path("date") String date,
                                             @Path("daylight") boolean daylight,
                                             @Path("method") String method);

    /*
    // Disable block code, already injected using dagger
    class ServiceFactory {

        public APIService createRetrofitService() {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(new MainActivity().URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);
        }
    }
    */
}
