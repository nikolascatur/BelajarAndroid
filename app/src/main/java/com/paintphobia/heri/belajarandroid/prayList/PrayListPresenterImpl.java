package com.paintphobia.heri.belajarandroid.prayList;

import com.paintphobia.heri.belajarandroid.services.APIService;
import com.paintphobia.heri.belajarandroid.services.PrayTimesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by heri on 6/11/2016.
 */
public class PrayListPresenterImpl implements PrayListPresenter, PrayListInteractor.OnSubmitListener {

    private PrayListView prayListView;
    private PrayListInteractor prayListInteractor;

    private String strLocation, strTime, strDate, strMethod;
    private boolean bDaylight;

    public PrayListPresenterImpl(PrayListView view) {
        this.prayListView = view;
        this.prayListInteractor = new PrayListInteractorImpl();
    }

    @Override
    public void submitRequest(String location, String times, String date, boolean daylight, String method) {
//        strLocation = location;
        strLocation = "yogyakarta";
        strTime = times;
        strDate = date;
        strMethod = method;
        bDaylight = daylight;

        prayListInteractor.submit(strLocation, strTime, strDate, bDaylight, strMethod, this);
    }

    @Override
    public void onDestroy() {
        prayListView = null;
    }

    @Override
    public void onDateError() {
        if(prayListView != null) {
            prayListView.onFailure("Set The Date First");
        }
    }

    @Override
    public void onLocationError() {
        if(prayListView != null) {
            prayListView.onFailure("Set The Location First");
        }
    }

    @Override
    public void onMethodError() {
        if(prayListView != null) {
            prayListView.onFailure("Choose The Method First");
        }
    }

    @Override
    public void onTimeError() {
        if(prayListView != null) {
            prayListView.onFailure("Set The Time Span First");
        }
    }

    @Override
    public void onSuccess() {
        if(prayListView != null) {

            prayListView.showProgress();

            APIService service = new APIService.ServiceFactory().createRetrofitService();
            Call<PrayTimesResponse> call = service.requestPrayTimes(strLocation, strTime, strDate, bDaylight, strMethod);
            call.enqueue(new Callback<PrayTimesResponse>() {
                @Override
                public void onResponse(Call<PrayTimesResponse> call, Response<PrayTimesResponse> response) {
                    if(response.isSuccessful()) {
                        PrayTimesResponse prayTimesResponse = response.body();
                        prayListView.onSuccess(prayTimesResponse);
                    } else {
                        prayListView.onFailure("Response FAIL");
                    }
                    prayListView.hideProgress();
                }

                @Override
                public void onFailure(Call<PrayTimesResponse> call, Throwable t) {
                    prayListView.onFailure("FAIL CALL : "+t.getMessage());
                    prayListView.hideProgress();
                }
            });
        }
    }
}
