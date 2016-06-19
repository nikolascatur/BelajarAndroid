package com.paintphobia.heri.belajarandroid.prayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.InputType;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.paintphobia.heri.belajarandroid.MyApp;
import com.paintphobia.heri.belajarandroid.R;
import com.paintphobia.heri.belajarandroid.mainMenu.MainMenuActivity;
import com.paintphobia.heri.belajarandroid.services.APIService;
import com.paintphobia.heri.belajarandroid.services.PrayTimes;
import com.paintphobia.heri.belajarandroid.services.PrayTimesResponse;
import com.paintphobia.heri.belajarandroid.utils.NetworkError;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by heri on 6/11/2016.
 */
public class PrayListActivity extends android.support.v7.app.AppCompatActivity
        implements PrayListView,
        DatePickerDialog.OnDateSetListener{

    @Inject
    Retrofit retrofit;

    @Inject
    APIService service;

    private final String TAG = PrayListActivity.class.getSimpleName();

    private PrayListPresenter prayListPresenter;
    private ProgressDialog progressDialog;
    private Spinner spinnerTime, spinnerMethod;

    private String strTimeSpan, strMethod;
    private EditText inputDate, inputLocation;
    private Button buttonSubmit;

    private int spinnerTimePos;
    private int spinnerMethodPos;
    private boolean isUseDaylight = false;

    private ArrayList<PrayTimes> itemPrayData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray_list);

        progressDialog = new ProgressDialog(PrayListActivity.this);
        progressDialog.setMessage("Fetch Data");
        spinnerTime = (Spinner) findViewById(R.id.spinner_time);
        spinnerMethod = (Spinner) findViewById(R.id.spinner_method);
        inputDate = (EditText) findViewById(R.id.input_date);
        inputLocation = (EditText) findViewById(R.id.input_location);

        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                ((TextView) parent.getChildAt(0)).setTextSize(20f);
                strTimeSpan = parent.getItemAtPosition(position).toString();
                spinnerTimePos = position;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(parent.getContext(), strTimeSpan, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                strMethod = ""+position;
                spinnerMethodPos = position;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(parent.getContext(), strMethod, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        inputDate.setInputType(InputType.TYPE_NULL);
        inputDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    hideSoftKeyboard();
                    datePicker();
                }
            }
        });

        buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerTimePos > 0 && spinnerMethodPos > 0) {
                    prayListPresenter.submitRequest(inputLocation.getText().toString(),
                            strTimeSpan,
                            inputDate.getText().toString(),
                            isUseDaylight,
                            strMethod
                            );
                } else {
                    if(spinnerMethodPos <= 0) {
                        showToast("Choose The Method First");
                    } else if (spinnerTimePos <= 0) {
                        showToast("Set The Date First");
                    }
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        ((MyApp) getApplication()).getBackEndComponent().inject(this);

        prayListPresenter = new PrayListPresenterImpl(service, this);
    }


    private void datePicker()
    {
        Calendar now = Calendar.getInstance();

        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.setThemeDark(false);
        datePickerDialog.vibrate(false);
        datePickerDialog.dismissOnPause(false);
        datePickerDialog.setAccentColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        datePickerDialog.showYearPickerFirst(false);

        Calendar[] dates = new Calendar[13];
        for(int i = -6; i <= 6; i++)
        {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.WEEK_OF_YEAR, i);
            dates[i+6] = date;
        }
        datePickerDialog.setHighlightedDays(dates);
        datePickerDialog.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void onSuccess(PrayTimesResponse prayTimesResponse) {

        Toast.makeText(PrayListActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
        itemPrayData = new ArrayList<>(prayTimesResponse.getItems());
        Intent intentSender = new Intent(PrayListActivity.this, MainMenuActivity.class);
        intentSender.putExtra("FETCH_RESULT", itemPrayData);
        setResult(Activity.RESULT_OK, intentSender);

        finish();
    }

    @Override
    public void onFailure(NetworkError networkError) {
        Toast.makeText(PrayListActivity.this, networkError.getAppErrorMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(PrayListActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = ""+dayOfMonth+"-"+(++monthOfYear)+"-"+year;
        inputDate.setText(date);
    }
}
