package me.didik.mvpdemo.injection;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.didik.mvpdemo.feature.home.ContentFragment;
import me.didik.mvpdemo.feature.home.HomeActivity;
import me.didik.mvpdemo.feature.main.MainActivity;

/**
 * Created by didik on 8/12/17.
 */
@Module
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector
    abstract ContentFragment bindContentFragment();
}
