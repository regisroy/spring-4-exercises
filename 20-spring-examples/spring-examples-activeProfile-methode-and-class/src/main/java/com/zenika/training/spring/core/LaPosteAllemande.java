package com.zenika.training.spring.core;

import org.springframework.beans.factory.annotation.Autowired;

public class LaPosteAllemande extends RecorderSupport implements PosteNationale {

    @Autowired
    private PosteService posteService;

    @Override
    public void distribuerLeCourrierDansTonPays() {
        record("ALLEMAGNE");
        posteService.remettreLeCourrier();
    }
}
