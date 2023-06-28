package com.kkm.kkm_server_v2.domain.location.exception;

import com.kkm.kkm_server_v2.domain.location.exception.error.LocationErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class LocationSelectedCannotDeleteException extends KkmException {
    public static final LocationSelectedCannotDeleteException EXCEPTION = new LocationSelectedCannotDeleteException();

    private LocationSelectedCannotDeleteException() {
        super(LocationErrorProperty.LOCATION_SELECTED_CANNOT_DELETE);
    }
}
