package com.zenika.region;

public class RegionInMemoryRepository implements RegionRepository {

    @SuppressWarnings("unused")
	private Region[] regions;

    public RegionInMemoryRepository(Region... regions) {
        this.regions = regions;
    }
}
