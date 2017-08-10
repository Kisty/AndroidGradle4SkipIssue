package uk.co.imagitech.gradleassumebug;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void skippyMcskipface() throws Exception {
        assumeTrue(false);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}