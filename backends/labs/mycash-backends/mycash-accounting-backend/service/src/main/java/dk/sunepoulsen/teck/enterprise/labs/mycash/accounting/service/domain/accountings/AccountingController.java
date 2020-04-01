package dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.domain.accountings;

import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping(method = RequestMethod.POST, value = "/accountings")
    public Accounting createAccounting(@RequestBody Accounting accounting) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
