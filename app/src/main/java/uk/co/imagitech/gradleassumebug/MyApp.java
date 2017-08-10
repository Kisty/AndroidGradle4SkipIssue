package uk.co.imagitech.gradleassumebug;

import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by TimKist on 10/08/2017.
 */

public class MyApp extends MultiDexApplication {
    @Inject
    Object something;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .penaltyLog()
                    .build());
        }
        try {
            //Simulate app start up
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // do nothing
        }
        SimpleComponent component = DaggerMyApp_SimpleComponent.create();
        component.inject(this);

        Log.d(MyApp.class.getSimpleName(), "something: " + something);
    }

    @Component(modules = SimpleModule.class)
    @Singleton
    public interface SimpleComponent {
        void inject(MyApp app);
    }

    @Module
    public static class SimpleModule {
        public SimpleModule() {
        }

        @Provides
        public Object something() {
            return new Object();
        }
    }


}
