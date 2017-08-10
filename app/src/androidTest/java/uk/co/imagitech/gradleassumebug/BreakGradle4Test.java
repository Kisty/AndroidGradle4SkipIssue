package uk.co.imagitech.gradleassumebug;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assume.assumeTrue;

/**
 * Created by TimKist on 09/08/2017.
 */
@RunWith(AndroidJUnit4.class)
public class BreakGradle4Test {

    @Test
    public void skippyMcskipface() throws Exception {
        assumeTrue(false);
    }
}
