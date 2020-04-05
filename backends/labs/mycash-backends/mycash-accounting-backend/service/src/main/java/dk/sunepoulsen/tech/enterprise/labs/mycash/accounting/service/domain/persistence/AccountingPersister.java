package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence;

import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.logic.DuplicateResourceException;
import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.logic.PatchUtilities;
import dk.sunepoulsen.tech.enterprise.labs.core.service.domain.logic.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public AccountingEntity updateAccounting( Long id, AccountingEntity entity ) {
        Optional<AccountingEntity> optionalEntity = repository.findById(id);
        if( optionalEntity.isEmpty()) {
            throw new ResourceNotFoundException("id", "No accounting exists");
        }

        if( repository.findByName(entity.getName()) != null) {
            throw new DuplicateResourceException("name", "An accounting already exist");
        }

        AccountingEntity foundEntity = optionalEntity.get();
        foundEntity.setName(PatchUtilities.patchValue(foundEntity.getName(), entity.getName()));
        foundEntity.setDescription(PatchUtilities.patchValue(foundEntity.getDescription(), entity.getDescription()));

        return repository.save(foundEntity);
    }
}
