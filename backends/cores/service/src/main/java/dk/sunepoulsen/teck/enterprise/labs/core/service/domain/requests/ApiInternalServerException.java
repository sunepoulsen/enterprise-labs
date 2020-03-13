package dk.sunepoulsen.teck.enterprise.labs.core.service.domain.requests;

/**
 * Created by sunepoulsen on 19/12/2016.
 */
public class ApiInternalServerException extends ApiException {
    public ApiInternalServerException( Throwable ex ) {
        super( "Unable to complete request", ex );
    }

    @Override
    public String toString() {
        return "ApiInternalServerException{} " + super.toString();
    }
}
