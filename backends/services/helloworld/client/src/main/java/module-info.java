/**
 * Module for the core client that is used by all services.
 */
module tech.enterprise.labs.helloworld.client {
    requires slf4j.api;
    requires tech.enterprise.labs.core.client;
    requires io.reactivex.rxjava2;

    exports dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client;
    exports dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client.model;
}
