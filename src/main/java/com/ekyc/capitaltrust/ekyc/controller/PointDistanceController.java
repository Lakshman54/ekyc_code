package com.ekyc.capitaltrust.ekyc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/users"})
public class PointDistanceController {
    public final double EARTH_RADIUS = 6371.0;

    public PointDistanceController() {
    }

    public double calculateDistance(Double lat1, Double long1, Double lat2, Double long2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(long1);
        double lon2Rad = Math.toRadians(long2);
        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2.0);
        double y = lat2Rad - lat1Rad;
        double distance = Math.sqrt(x * x + y * y) * 6371.0;
        return distance * 1000.0;
    }

    @GetMapping({"/pointdistance/{lat1}/{long1}"})
    public void distancelocation(@PathVariable Double lat1, @PathVariable Double long1) {
        System.out.println("Given latitude and longitude position of person now are :: latitude::" + lat1 + " longitude::" + long1);
        Double Businesslat1 = 17.419513;
        Double Businesslon1 = 78.493229;
        Double businessDis = this.calculateDistance(Businesslat1, Businesslon1, lat1, long1);
        System.out.println("His business location is:: latitude::" + Businesslat1 + " longitude::" + Businesslon1);
        System.out.println("distance from business to his location in meters::" + businessDis + " meters");
        Double Homelat1 = 17.419589;
        Double Homelon1 = 78.49269;
        System.out.println("His Home location is:: latitude::" + Homelat1 + " longitude::" + Homelon1);
        Double homeDis = this.calculateDistance(Homelat1, Homelon1, lat1, long1);
        System.out.println("distance from home to his location in meters::" + homeDis + " meters");
        Double range = 100.0;
        if (!(homeDis < range) && !(businessDis < range)) {
            System.out.println("The employee is not within the " + range + " meters range");
        } else {
            System.out.println("The employee is within the " + range + " meters range");
        }

    }
}

