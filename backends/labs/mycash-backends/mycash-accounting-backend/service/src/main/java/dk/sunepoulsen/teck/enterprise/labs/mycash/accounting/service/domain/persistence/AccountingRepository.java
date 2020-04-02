package dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.domain.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends CrudRepository<AccountingEntity, Long> {
}
