package net.takasing.springbootsandbox.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by takasing
 */
@Component
@Slf4j
public class AsyncTask {

    @Async("heavyTaskExecutor")
    public void supplyAndConsume() {
        Supplier<Integer> initValueSupplier = () -> 100;
        Consumer<Integer> valueConsumer = value -> log.info(value.toString());


        CompletableFuture.supplyAsync(initValueSupplier)
                .thenAcceptAsync(valueConsumer);
    }

    @Async("heavyTaskExecutor")
    public void simpleSleepTask() {
        try {
            log.info("start async");
            TimeUnit.SECONDS.sleep(5);
            log.info("finish async");
        } catch (InterruptedException e) {
            log.error("sleep error", e);
        }
    }

}
