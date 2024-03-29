package test.exo;

import org.junit.Assert;
import org.junit.Test;

public class CalculsTest {

    @Test
    public void testCalculsX() {
        // Test when x is less than 0
        Assert.assertEquals(2, Calculs.calculsX(-1));

        // Test when x is 0
        Assert.assertEquals(1, Calculs.calculsX(0));

        // Test when x is greater than 0
        Assert.assertEquals(3, Calculs.calculsX(3));
    }
}