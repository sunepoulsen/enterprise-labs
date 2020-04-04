package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends JpaRepository<AccountingEntity, Long> {
    @Query("SELECT a FROM AccountingEntity a WHERE a.name = :name")
    AccountingEntity findByName(@Param("name") String name);
}
