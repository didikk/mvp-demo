package me.didik.mvpdemo.util;

import android.content.Context;

/**
 * Created by didik on 8/12/17.
 */

public class Me {
    private Context context;

    public Me(Context context) {
        this.context = context;
    }

    public String sayHello() {
        return "Hello from Me";
    }
}
