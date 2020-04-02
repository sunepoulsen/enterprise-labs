package dk.sunepoulsen.teck.enterprise.labs.core.service.domain.logic;

import dk.sunepoulsen.teck.enterprise.labs.core.service.domain.requests.ApiException;
import dk.sunepoulsen.teck.enterprise.labs.core.service.domain.requests.ApiNotFoundException;

public class ResourceNotFoundException extends LogicException {
    public static final String DEFAULT_MESSAGE = "Resource does not exist";

    public ResourceNotFoundException( String message ) {
        super( message );
    }

    public ResourceNotFoundException( String message, Throwable ex ) {
        super( message, ex );
    }

    public ResourceNotFoundException( String param, String message ) {
        super( param, message );
    }

    public ResourceNotFoundException( String param, String message, Throwable ex ) {
        super( param, message, ex );
    }

    public ResourceNotFoundException( String code, String param, String message ) {
        super( code, param, message );
    }

    public ResourceNotFoundException( String code, String param, String message, Throwable ex ) {
        super( code, param, message, ex );
    }

    @Override
    public ApiException mapApiException() {
        return new ApiNotFoundException( getCode(), getParam(), getMessage(), this );
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{} " + super.toString();
    }
}
