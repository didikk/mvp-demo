package me.didik.mvpdemo.feature.main;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import me.didik.mvpdemo.data.UserRepository;

/**
 * Created by didik on 8/5/17.
 */

public class MainPresenter {
    private MainView view;
    private UserRepository userRepository;

    @Inject
    public MainPresenter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void attachView(MainView view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    @NonNull
    public MainView getView() {
        if (view == null) {
            throw new IllegalStateException("View died");
        }

        return view;
    }

    public void doLogin(String email, String pass) {
        if (email.isEmpty()) {
            getView().showErrorMessage("Email cannot be blank");
            return;
        }

        if (pass.isEmpty()) {
            getView().showErrorMessage("Password cannot be blank");
            return;
        }

        if (userRepository.isUserValid(email, pass))
            getView().openHomepage();
        else getView().showErrorMessage("Email or password are invalid");
    }
}
