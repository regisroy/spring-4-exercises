package com.zenika.training.spring.core.service;

public class ServiceBase implements Service {

    @Override
    public void execute() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ServiceBase.execute <<<<<<<<<<<<<<< CECI EST MON SERVICE LANCE DANS LA SERVLET");
    }

}
