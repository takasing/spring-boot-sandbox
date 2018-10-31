package net.takasing.springbootsandbox.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by takasing
 */
@Slf4j
@RestController
@RequestMapping("/asyncTask")
public class AsyncTaskController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/sleep")
    public Boolean simpleSleep() {
        asyncTask.simpleSleepTask();
        log.info("through async task");
        return true;
    }
}
