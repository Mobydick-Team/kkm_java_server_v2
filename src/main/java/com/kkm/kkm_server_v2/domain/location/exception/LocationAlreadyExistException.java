package com.kkm.kkm_server_v2.domain.location.exception;

import com.kkm.kkm_server_v2.domain.location.exception.error.LocationErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class LocationAlreadyExistException extends KkmException {
    public static final LocationAlreadyExistException EXCEPTION = new LocationAlreadyExistException();

    private LocationAlreadyExistException() {
        super(LocationErrorProperty.LOCATION_ALREADY_EXIST);
    }
}
