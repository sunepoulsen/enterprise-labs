package dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.AbstractIntegrator;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.exceptions.ClientException;
import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import io.reactivex.Single;

public class AccountingIntegrator extends AbstractIntegrator {
    public AccountingIntegrator(TechEnterpriseLabsClient httpClient) {
        super(httpClient);
    }

    public Single<Accounting> createAccounting(Accounting accounting) {
        return Single.fromFuture(httpClient.post("/accountings", accounting, Accounting.class))
            .onErrorResumeNext(this::mapClientExceptions);
    }

    protected <T> Single<T> mapClientExceptions(Throwable throwable) {
        if( throwable instanceof ClientException ) {
            return Single.error(throwable);
        }

        if( throwable.getCause() != null ) {
            return mapClientExceptions(throwable.getCause());
        }

        return Single.error(throwable);
    }
}
