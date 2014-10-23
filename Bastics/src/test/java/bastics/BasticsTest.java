package bastics;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BasticsTest extends TestCase {

    @Test
    public void testComputeBasicStatistics() throws Exception {

        Bastics.computeBasicStatistics("/Users/a13553/Desktop/dataset/ameba/10d_ad.tsv");

    }
}