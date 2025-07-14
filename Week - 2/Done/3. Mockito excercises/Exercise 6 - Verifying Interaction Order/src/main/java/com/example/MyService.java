package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyService {
    private final ExternalApi api;
    private final Logger logger;

    public MyService(ExternalApi api, Logger logger) {
        this.api = api;
        this.logger = logger;
    }

    public MyService(ExternalApi api) {
        this(api, Logger.getLogger(MyService.class.getName()));
    }

    public String fetchData() {
        String data = api.getData();
        logger.log(Level.INFO, "done");
        return data;
    }
}
