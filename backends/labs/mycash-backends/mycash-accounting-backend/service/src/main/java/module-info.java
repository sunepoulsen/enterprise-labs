/**
 * Module for the core client that is used by all services.
 */
module tech.enterprise.labs.mycash.accounting.service {
    requires slf4j.api;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.webmvc;
    requires spring.web;
    requires tech.enterprise.labs.core.service;
    requires tech.enterprise.labs.mycash.accounting.client;
    requires org.hibernate.validator;
    requires java.validation;
    requires io.reactivex.rxjava2;
    requires java.persistence;
    requires spring.data.commons;
    requires spring.data.jpa;

    opens dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.domain.persistence;
}
