package com.paintphobia.heri.belajarandroid.services;

import com.paintphobia.heri.belajarandroid.MainActivity;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
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

    class ServiceFactory {
        public APIService createRetrofitService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(new MainActivity().URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(APIService.class);
        }
    }
}
