package com.zenika.training.spring.core;

import org.springframework.beans.factory.annotation.Autowired;

public class RecorderSupport {

    @Autowired
    private StringBuilder recorder;

    protected void record(String message) {
        recorder.append(message).append("\n");
    }

    protected String getRecords() {
        return recorder.toString();
    }


}
