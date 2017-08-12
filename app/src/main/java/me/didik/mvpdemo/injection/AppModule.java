package me.didik.mvpdemo.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.didik.mvpdemo.app.App;

/**
 * Created by didik on 8/12/17.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(App app){
        return app.getApplicationContext();
    }
}
