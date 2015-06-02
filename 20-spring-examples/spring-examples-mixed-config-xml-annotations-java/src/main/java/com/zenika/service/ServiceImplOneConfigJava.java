package com.zenika.service;

public class ServiceImplOneConfigJava implements Service {

    private StringBuilder recorder;

    public ServiceImplOneConfigJava(StringBuilder recorder) {
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        recorder.append("Instance : ").append(toString()).append("\n");
        recorder.append("   Execution de ").append(this.getClass().getName()).append(".execute()\n");
    }


}
