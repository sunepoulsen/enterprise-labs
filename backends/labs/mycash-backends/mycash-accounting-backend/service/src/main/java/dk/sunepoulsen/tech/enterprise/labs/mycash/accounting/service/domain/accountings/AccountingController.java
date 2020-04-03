package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.accountings;

import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.logic.LogicException;
import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.requests.ApiInternalServerException;
import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.validation.ApiValidator;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence.AccountingEntity;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence.AccountingPersister;
import org.hibernate.validator.cfg.defs.NullDef;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {
    private AccountingPersister accountingPersister;

    public AccountingController(AccountingPersister accountingPersister) {
        this.accountingPersister = accountingPersister;
    }

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping(method = RequestMethod.POST, value = "/accountings")
    public Accounting createAccounting(@RequestBody Accounting accounting) {
        ApiValidator.validate(accounting, Accounting.class, mappings -> mappings
            .field("id")
                .ignoreAnnotations(true)
                .constraint(new NullDef())
        );

        try {
            AccountingEntity entity = AccountingTransformations.toEntity(accounting);
            entity = accountingPersister.createAccounting(entity);

            return AccountingTransformations.fromEntity(entity);
        }
        catch(LogicException ex ) {
            ex.throwApiException();
        }

        throw new ApiInternalServerException();
    }
}
