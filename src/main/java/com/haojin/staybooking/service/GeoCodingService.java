package com.haojin.staybooking.service;

import com.google.api.gax.rpc.ApiException;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.haojin.staybooking.exception.GeoCodingException;
import com.haojin.staybooking.exception.InvalidStayAddressException;
import com.haojin.staybooking.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeoCodingService {

    private GeoApiContext geoApiContext;

    @Autowired
    public GeoCodingService(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    public Location getLatLng(Long id, String address) throws GeoCodingException {
       try {
           GeocodingResult result = GeocodingApi.geocode(geoApiContext, address).await()[0];
           if (result.partialMatch) {
               throw new InvalidStayAddressException("Failed to find stay address");
           }
           return new Location(id, new GeoPoint(result.geometry.location.lat, result.geometry.location.lng));

       } catch (IOException | ApiException | InterruptedException | com.google.maps.errors.ApiException ex) {
           ex.printStackTrace();
           throw new GeoCodingException("Failed to encode stay address");

       }
    }




}
