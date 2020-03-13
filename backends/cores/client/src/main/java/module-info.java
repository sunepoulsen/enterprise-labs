/**
 * Module for the core client that is used by all services.
 */
module mycash.core.client {
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires io.reactivex.rxjava2;
    requires java.net.http;
    requires slf4j.api;
}
