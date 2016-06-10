package com.paintphobia.heri.belajarandroid.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.paintphobia.heri.belajarandroid.MainActivity;
import com.paintphobia.heri.belajarandroid.R;

/**
 * Created by heri on 6/9/2016.
 */
public class LoginActivity extends Activity implements LoginView, View.OnClickListener{

    private ProgressBar progressBar;
    private EditText input_username;
    private EditText input_password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        input_username = (EditText) findViewById(R.id.username);
        input_password = (EditText) findViewById(R.id.password);

        findViewById(R.id.button_login).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        input_username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        input_password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToMenu() {
        Intent intentMenu = new Intent(this, MainActivity.class);
        startActivity(intentMenu);

        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(input_username.getText().toString(), input_password.getText().toString());
    }
}
