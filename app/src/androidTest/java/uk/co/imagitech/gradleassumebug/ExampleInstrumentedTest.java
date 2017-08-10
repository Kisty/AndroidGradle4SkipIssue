package uk.co.imagitech.gradleassumebug;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("uk.co.imagitech.gradleassumebug", appContext.getPackageName());
    }

    @Test
    public void dagger() throws Exception {
        MyApp.SimpleComponent component = DaggerMyApp_SimpleComponent.create();
        component.inject(((MyApp) InstrumentationRegistry.getTargetContext()));
    }

    @Component(modules = MyApp.SimpleModule.class)
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
