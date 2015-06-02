package com.zenika.training.spring.core;

import org.springframework.context.annotation.Profile;

public class PosteAChevalService extends RecorderSupport implements PosteService {


    @Override
    public void remettreLeCourrier() {
        record("Le courrier est transporte A CHEVAL");
    }
}
