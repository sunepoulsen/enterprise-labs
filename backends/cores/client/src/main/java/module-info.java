/**
 * Module for the core client that is used by all services.
 */
module tech.enterprise.labs.core.client {
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires io.reactivex.rxjava2;
    requires java.net.http;
    requires slf4j.api;

    exports dk.sunepoulsen.teck.enterprise.labs.core.rs.client;
    exports dk.sunepoulsen.teck.enterprise.labs.core.rs.client.exceptions;
    exports dk.sunepoulsen.teck.enterprise.labs.core.rs.client.generators;
    exports dk.sunepoulsen.teck.enterprise.labs.core.rs.client.model;
    exports dk.sunepoulsen.teck.enterprise.labs.core.rs.client.model.monitoring;
}
