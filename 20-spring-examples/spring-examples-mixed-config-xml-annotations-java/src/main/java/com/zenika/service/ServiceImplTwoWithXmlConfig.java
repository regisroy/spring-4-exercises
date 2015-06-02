package com.zenika.service;

public class ServiceImplTwoWithXmlConfig implements Service {

    private StringBuilder recorder;

    public ServiceImplTwoWithXmlConfig(StringBuilder recorder) {
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        recorder.append("Instance : ").append(toString()).append("\n");
        recorder.append("   Execution de ").append(this.getClass().getName()).append(".execute()\n");
    }
}
