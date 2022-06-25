package com.haojin.staybooking.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomLocationRepository {
    List<Long> searchByDistance(double lat, double lon, String distance);
}
