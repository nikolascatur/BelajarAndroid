package com.paintphobia.heri.belajarandroid.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.paintphobia.heri.belajarandroid.R;
import com.paintphobia.heri.belajarandroid.mainMenu.MainMenuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by heri on 6/9/2016.
 */
public class LoginActivity extends AppCompatActivity implements LoginView{

    private final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.username)
    EditText input_username;

    @BindView(R.id.password)
    EditText input_password;

    private LoginPresenter presenter;

    @BindView(R.id.button_login)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

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
        Intent intentMenu = new Intent(this, MainMenuActivity.class);
        startActivity(intentMenu);

        finish();
    }

    @OnClick(R.id.button_login)
    public void submitLogin() {
        presenter.validateCredentials(input_username.getText().toString(), input_password.getText().toString());
    }
}
