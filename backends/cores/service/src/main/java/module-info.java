/**
 * Module for the core client that is used by all services.
 */
module tech.enterprise.labs.core.service {
    requires io.reactivex.rxjava2;
    requires java.validation;
    requires org.apache.log4j;
    requires org.hibernate.validator;
    requires perf4j;
    requires slf4j.api;
    requires spring.context;
    requires spring.web;
    requires spring.webmvc;
    requires tech.enterprise.labs.core.client;
    requires static org.apache.tomcat.embed.core;

    exports dk.sunepoulsen.teck.enterprise.labs.core.service.domain.logic;
    exports dk.sunepoulsen.teck.enterprise.labs.core.service.domain.requests;
    exports dk.sunepoulsen.teck.enterprise.labs.core.service.domain.validation;
}
