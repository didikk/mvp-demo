package me.didik.mvpdemo.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.didik.mvpdemo.data.UserRepository;

/**
 * Created by didik on 8/12/17.
 */
@Module
public class RepoModule {
    @Provides
    @Singleton
    UserRepository provideUserRepository() {
        return new UserRepository();
    }
}
