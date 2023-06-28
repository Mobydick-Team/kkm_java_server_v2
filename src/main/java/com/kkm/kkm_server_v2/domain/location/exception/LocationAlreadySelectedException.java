package com.kkm.kkm_server_v2.domain.location.exception;

import com.kkm.kkm_server_v2.domain.location.exception.error.LocationErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class LocationAlreadySelectedException extends KkmException {
    public static final LocationAlreadySelectedException EXCEPTION = new LocationAlreadySelectedException();

    private LocationAlreadySelectedException() {
        super(LocationErrorProperty.LOCATION_ALREADY_SELECTED);
    }

}
