package com.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingNumberService {
    private static final Logger log = LoggerFactory.getLogger(TrackingNumberService.class);
    private final RedisService redisService;

    @Autowired
    public TrackingNumberService(RedisService redisService) {
        this.redisService = redisService;
    }

    public String generateTrackingNumber() {
        String trackingNumber = null;
        try {
            trackingNumber = redisService.insertUniqueValue();
        } catch (Exception e) {
            log.error("Exception occurred ", e);
        }

        return trackingNumber;
    }
}
