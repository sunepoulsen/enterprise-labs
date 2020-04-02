package dk.sunepoulsen.teck.enterprise.labs.core.rs.client;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.exceptions.ClientException;
import io.reactivex.Single;

public class AbstractIntegrator {
    protected final TechEnterpriseLabsClient httpClient;

    public AbstractIntegrator(TechEnterpriseLabsClient httpClient) {
        this.httpClient = httpClient;
    }

    protected <T> Single<T> mapClientExceptions(Throwable throwable) {
        if( throwable instanceof ClientException) {
            return Single.error(throwable);
        }

        if( throwable.getCause() != null ) {
            return mapClientExceptions(throwable.getCause());
        }

        return Single.error(throwable);
    }
}
