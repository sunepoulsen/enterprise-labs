package dk.sunepoulsen.teck.enterprise.labs.core.rs.client;

public class AbstractIntegrator {
    protected final TechEnterpriseLabsClient httpClient;

    public AbstractIntegrator(TechEnterpriseLabsClient httpClient) {
        this.httpClient = httpClient;
    }
}
