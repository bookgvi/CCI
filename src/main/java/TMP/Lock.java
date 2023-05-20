package TMP;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lock {
    private final Map<String, String> dummyMap = new HashMap<>();

    public void deadLock() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            synchronized (dummyMap) {
                process();
            }
        });
        service.shutdown();
    }

    private void process() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            synchronized (dummyMap) {
                dummyMap.putIfAbsent("QQQ", "QQQ");
            }
        });
        service.shutdown();
    }
}
