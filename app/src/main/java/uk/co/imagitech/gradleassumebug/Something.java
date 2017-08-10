package uk.co.imagitech.gradleassumebug;

/**
 * Created by TimKist on 09/08/2017.
 */

public class Something {
    public void lambda() {
        Runnable runnable = () -> {
            System.out.println("A lambda");
            return;
        };
        runnable.run();
    }
}
