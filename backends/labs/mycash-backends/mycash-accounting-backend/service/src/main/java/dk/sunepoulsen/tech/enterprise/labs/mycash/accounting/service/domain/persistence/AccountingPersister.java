package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence;

import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.logic.DuplicateResourceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountingPersister {
    private AccountingRepository repository;

    public AccountingPersister(AccountingRepository repository) {
        this.repository = repository;
    }

    public AccountingEntity createAccounting( AccountingEntity entity ) {
        if( repository.findByName(entity.getName()) != null) {
            throw new DuplicateResourceException("name", "An accounting already exist");
        }

        return repository.save(entity);
    }

    public Page<AccountingEntity> getAccountings(int page, int count) {
        PageRequest request = PageRequest.of(page, count);
        return repository.findAll(request);
    }
}
