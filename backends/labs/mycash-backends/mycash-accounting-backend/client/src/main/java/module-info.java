/**
 * Module for the core client that is used by all services.
 */
module tech.enterprise.labs.mycash.accounting.client {
    requires slf4j.api;
    requires tech.enterprise.labs.core.client;
    requires io.reactivex.rxjava2;
    requires java.validation;

    exports dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client;
    exports dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client.model;
}
