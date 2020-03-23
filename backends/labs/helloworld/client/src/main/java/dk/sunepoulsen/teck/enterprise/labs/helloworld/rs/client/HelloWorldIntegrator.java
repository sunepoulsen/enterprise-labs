package dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.AbstractIntegrator;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client.model.Greetings;
import io.reactivex.Observable;

public class HelloWorldIntegrator extends AbstractIntegrator {
    public HelloWorldIntegrator(TechEnterpriseLabsClient httpClient) {
        super(httpClient);
    }

    public Observable<Greetings> greetings() {
        return Observable.fromFuture(httpClient.get( "/greetings", Greetings.class));
    }
}
