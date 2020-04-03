package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client;

import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.AbstractIntegrator;
import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import io.reactivex.Single;

public class AccountingIntegrator extends AbstractIntegrator {
    public AccountingIntegrator(TechEnterpriseLabsClient httpClient) {
        super(httpClient);
    }

    public Single<Accounting> createAccounting(Accounting accounting) {
        return Single.fromFuture(httpClient.post("/accountings", accounting, Accounting.class))
            .onErrorResumeNext(this::mapClientExceptions);
    }
}
