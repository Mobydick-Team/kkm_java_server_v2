package com.kkm.kkm_server_v2.domain.location.exception;

import com.kkm.kkm_server_v2.domain.location.exception.error.LocationErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class LocationCountExceedException extends KkmException {
    public static final LocationCountExceedException EXCEPTION = new LocationCountExceedException();

    private LocationCountExceedException() {
        super(LocationErrorProperty.LOCATION_COUNT_EXCEED);
    }
}
