package dk.sunepoulsen.teck.enterprise.labs.core.rs.client;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.model.monitoring.ServiceStatus;
import io.reactivex.Observable;

public class TechEnterpriseLabsIntegrator {
    private TechEnterpriseLabsClient httpClient;

    public TechEnterpriseLabsIntegrator(TechEnterpriseLabsClient httpClient) {
        this.httpClient = httpClient;
    }

    public Observable<ServiceStatus> status() {
        return Observable.fromFuture(httpClient.get("/mx/status", ServiceStatus.class));
    }

}
