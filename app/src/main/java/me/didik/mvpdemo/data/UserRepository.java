package me.didik.mvpdemo.data;

import me.didik.mvpdemo.User;

/**
 * Created by didik on 8/5/17.
 */

public class UserRepository {
    public boolean isUserValid(String email, String pass) {
        return email.equalsIgnoreCase("didik@me.xyz") && pass.equalsIgnoreCase("password");
    }

    public User getUser(){
        return new User();
    }
}
