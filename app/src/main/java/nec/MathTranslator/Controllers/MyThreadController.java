package nec.MathTranslator.Controllers;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadController implements MyController {

    private MyMainController mainController;
    ExecutorService threadPool = Executors.newCachedThreadPool(); // TODO: set up ThreadFactories for specific implementations down the line

    public MyThreadController(MyMainController control) {
        this.mainController = control;

        System.out.println(Instant.now() + ": MyThreadController Initialized");
    }

    protected void passTaskToThreadPool(Runnable r) {
        threadPool.submit(r);
    }
}
