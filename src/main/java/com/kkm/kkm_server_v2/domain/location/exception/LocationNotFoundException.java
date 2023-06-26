package com.kkm.kkm_server_v2.domain.location.exception;

import com.kkm.kkm_server_v2.domain.location.exception.error.LocationErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class LocationNotFoundException extends KkmException {
    public static final LocationNotFoundException EXCEPTION = new LocationNotFoundException();

    private LocationNotFoundException() {
        super(LocationErrorProperty.LOCATION_NOT_FOUND);
    }
}
