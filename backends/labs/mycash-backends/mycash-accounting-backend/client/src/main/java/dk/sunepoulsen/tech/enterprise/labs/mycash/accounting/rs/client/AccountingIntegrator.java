package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client;

import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.AbstractIntegrator;
import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.AccountingPagination;
import io.reactivex.Single;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class AccountingIntegrator extends AbstractIntegrator {
    public AccountingIntegrator(TechEnterpriseLabsClient httpClient) {
        super(httpClient);
    }

    public Single<Accounting> createAccounting(Accounting accounting) {
        return Single.fromFuture(httpClient.post("/accountings", accounting, Accounting.class))
            .onErrorResumeNext(this::mapClientExceptions);
    }

    public Single<AccountingPagination> getAccountings(Integer page, Integer count) {
        Map<String, String> queryParams = new HashMap<>();
        if( page != null ) {
            queryParams.put("page", String.valueOf(page));
        }
        if( count != null) {
            queryParams.put("count", String.valueOf(count));
        }

        return Single.fromFuture(httpClient.get("/accountings" + createHttpQuery(queryParams), AccountingPagination.class))
            .onErrorResumeNext(this::mapClientExceptions);
    }

    protected String createHttpQuery(Map<String, String> params) {
        if( params.isEmpty()) {
            return "";
        }

        StringBuffer result = new StringBuffer();

        result.append('?');
        params.forEach((key, value) -> {
            result.append(key);
            result.append('=');
            result.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
            result.append('&');
        });
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
