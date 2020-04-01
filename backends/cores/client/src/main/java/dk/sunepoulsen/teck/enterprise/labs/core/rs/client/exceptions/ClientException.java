package dk.sunepoulsen.teck.enterprise.labs.core.rs.client.exceptions;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.model.ServiceError;

import java.net.http.HttpResponse;
import java.util.Objects;

public class ClientException extends RuntimeException {
    private HttpResponse<String> response;
    private ServiceError serviceError;

    public ClientException(HttpResponse<String> response, ServiceError serviceError) {
        this(response, serviceError, null);
    }

    public ClientException(HttpResponse<String> response, ServiceError serviceError, Throwable throwable) {
        super(serviceError.getMessage(), throwable);
        this.response = response;
        this.serviceError = serviceError;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientException that = (ClientException) o;
        return Objects.equals(response, that.response) &&
            Objects.equals(serviceError, that.serviceError);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, serviceError);
    }

    @Override
    public String toString() {
        return "ClientException{" +
            "response=" + response +
            ", serviceError=" + serviceError +
            '}';
    }
}
