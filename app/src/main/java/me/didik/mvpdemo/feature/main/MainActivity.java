package me.didik.mvpdemo.feature.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import me.didik.mvpdemo.R;
import me.didik.mvpdemo.feature.home.HomeActivity;
import me.didik.mvpdemo.util.Me;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject Me me;
    @Inject MainPresenter mainPresenter;

    private EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPass = (EditText) findViewById(R.id.et_pass);

        mainPresenter.attachView(this);

        System.out.println(me.sayHello());
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }

    public void submit(View view) {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        mainPresenter.doLogin(email, pass);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openHomepage() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void showLoading() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
    }
}
