package dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.domain.persistence;

import org.springframework.stereotype.Service;

@Service
public class AccountingPersister {
    private AccountingRepository repository;

    public AccountingPersister(AccountingRepository repository) {
        this.repository = repository;
    }

    public AccountingEntity createAccounting( AccountingEntity entity ) {
        return repository.save(entity);
    }
}
