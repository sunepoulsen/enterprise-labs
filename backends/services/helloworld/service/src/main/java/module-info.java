/**
 * Module for the core client that is used by all services.
 */
module tech.enterprise.labs.helloworld.service {
    requires slf4j.api;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.webmvc;
    requires tech.enterprise.labs.helloworld.client;
    requires spring.web;
    requires tech.enterprise.labs.core.service;
}
