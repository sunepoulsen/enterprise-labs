package dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.AbstractIntegrator;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client.model.Greetings;
import io.reactivex.Single;

public class HelloWorldIntegrator extends AbstractIntegrator {
    public HelloWorldIntegrator(TechEnterpriseLabsClient httpClient) {
        super(httpClient);
    }

    public Single<Greetings> greetings() {
        return Single.fromFuture(httpClient.get( "/greetings", Greetings.class))
                .onErrorResumeNext(this::mapClientExceptions);
    }
}
