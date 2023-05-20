package TMP;

import org.junit.Test;

import static org.junit.Assert.*;

public class LockTest {

    @Test
    public void deadLock() {
        Lock l = new Lock();
        l.deadLock();
    }
}