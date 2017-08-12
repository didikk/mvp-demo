package me.didik.mvpdemo.injection;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import me.didik.mvpdemo.app.App;

/**
 * Created by didik on 8/12/17.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class, BuildersModule.class, CommonModule.class, RepoModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

    void inject(App app);
}
