package com.zenika.pays;

import java.util.Arrays;
import java.util.List;

public class PaysInMemoryRepository implements PaysRepository {

    private Pays[] payses;

    public static PaysInMemoryRepository createWithPays(Pays... payses) {
        return new PaysInMemoryRepository(payses);
    }

    public PaysInMemoryRepository(Pays... payses) {
        this.payses = payses;
    }

    @Override
    public List<Pays> findAll() {

        return Arrays.asList(payses);
    }
}
