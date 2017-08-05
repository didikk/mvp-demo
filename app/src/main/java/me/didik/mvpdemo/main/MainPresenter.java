package me.didik.mvpdemo.main;

import me.didik.mvpdemo.data.UserRepository;

/**
 * Created by didik on 8/5/17.
 */

public class MainPresenter {
    private MainView view;
    private UserRepository userRepository;

    public MainPresenter(MainView view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
    }

    public void doLogin(String email, String pass) {
        if (email.isEmpty()) {
            view.showErrorMessage("Email cannot be blank");
            return;
        }

        if (pass.isEmpty()) {
            view.showErrorMessage("Password cannot be blank");
            return;
        }

        if (userRepository.isUserValid(email, pass))
            view.openHomepage();
        else view.showErrorMessage("Email or password are invalid");
    }
}
