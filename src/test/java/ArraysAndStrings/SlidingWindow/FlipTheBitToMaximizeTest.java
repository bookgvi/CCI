package ArraysAndStrings.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlipTheBitToMaximizeTest {

    @Test
    public void proceed() {
        String s = "1101100111";
        int k = 5;
        FlipTheBitToMaximize f = new FlipTheBitToMaximize();
        Assert.assertEquals("Максимальное число 1 при однократной замене 0 на 1", k, f.proceed(s));
    }
}