package dk.sunepoulsen.teck.enterprise.labs.core.rs.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.generators.RequestIdGenerator;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.generators.UUIDRequestIdGenerator;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Http Client to make calls to a Tech Enterprise Labs service.
 */
public class TechEnterpriseLabsClient {
    private URI uri;
    private HttpClient client;
    private Duration requestTimeout;

    private ObjectMapper objectMapper;
    private RequestIdGenerator requestIdGenerator;

    public TechEnterpriseLabsClient(URI uri) {
        this(uri, HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(30))
        );

        this.objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    public TechEnterpriseLabsClient(URI uri, HttpClient.Builder httpClientBuilder) {
        this.uri = uri;
        this.client = httpClientBuilder.build();
        this.requestTimeout = Duration.ofSeconds(30);

        this.requestIdGenerator = new UUIDRequestIdGenerator();
    }

    public <T> CompletableFuture<T> get(String url, Class<T> clazz) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(uri.resolve(url))
                .header("X-Request-ID", requestIdGenerator.generateId())
                .timeout(requestTimeout)
                .build();

        return client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(s -> toJson(s, clazz));
    }

    private <T> T toJson(String s, Class<T> clazz) {
        try {
            return objectMapper.readValue(s, clazz);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
