package dk.sunepoulsen.teck.enterprise.labs.core.rs.client;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.model.monitoring.ServiceStatus;
import io.reactivex.Observable;

public class TechEnterpriseLabsIntegrator extends AbstractIntegrator {
    public TechEnterpriseLabsIntegrator(TechEnterpriseLabsClient httpClient) {
        super(httpClient);
    }

    public Observable<ServiceStatus> status() {
        return Observable.fromFuture(httpClient.get("/mx/status", ServiceStatus.class));
    }

}
