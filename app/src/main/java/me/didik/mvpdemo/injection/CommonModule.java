package me.didik.mvpdemo.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.didik.mvpdemo.util.Me;

/**
 * Created by didik on 8/12/17.
 */
@Module
public class CommonModule {
    @Provides
    @Singleton
    Me provideMe(Context context){
        return new Me(context);
    }
}
