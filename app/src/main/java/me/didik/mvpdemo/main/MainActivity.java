package me.didik.mvpdemo.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import me.didik.mvpdemo.HomeActivity;
import me.didik.mvpdemo.R;
import me.didik.mvpdemo.data.UserRepository;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText etEmail, etPass;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPass = (EditText) findViewById(R.id.et_pass);

        mainPresenter = new MainPresenter(this, new UserRepository());
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
