package com.zenika.service;

public class ServiceImplTwo implements Service {

    private StringBuilder recorder;

    public ServiceImplTwo(StringBuilder recorder) {
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        recorder.append("Instance : ").append(toString()).append("\n");
        recorder.append("   Execution de ").append(this.getClass().getName()).append(".execute()\n");
    }
}
