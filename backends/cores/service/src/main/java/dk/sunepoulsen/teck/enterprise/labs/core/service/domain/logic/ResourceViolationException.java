package dk.sunepoulsen.teck.enterprise.labs.core.service.domain.logic;

import dk.sunepoulsen.teck.enterprise.labs.core.service.domain.requests.ApiBadRequestException;
import dk.sunepoulsen.teck.enterprise.labs.core.service.domain.requests.ApiException;

public class ResourceViolationException extends LogicException {
    public ResourceViolationException( String message ) {
        super( message );
    }

    public ResourceViolationException( String message, Throwable ex ) {
        super( message, ex );
    }

    public ResourceViolationException( String param, String message ) {
        super( param, message );
    }

    public ResourceViolationException( String param, String message, Throwable ex ) {
        super( param, message, ex );
    }

    public ResourceViolationException( String code, String param, String message ) {
        super( code, param, message );
    }

    public ResourceViolationException( String code, String param, String message, Throwable ex ) {
        super( code, param, message, ex );
    }

    @Override
    public ApiException mapApiException() {
        return new ApiBadRequestException( getCode(), getParam(), getMessage(), this );
    }

    @Override
    public String toString() {
        return "ResourceViolationException{} " + super.toString();
    }
}
