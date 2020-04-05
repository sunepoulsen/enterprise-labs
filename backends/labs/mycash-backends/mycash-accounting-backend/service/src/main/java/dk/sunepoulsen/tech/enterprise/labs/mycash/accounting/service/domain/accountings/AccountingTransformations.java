package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.accountings;

import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence.AccountingEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountingTransformations {
    public static Accounting fromEntity(AccountingEntity entity) {
        Accounting accounting = new Accounting();
        accounting.setId(entity.getId());
        accounting.setName(entity.getName());
        accounting.setDescription(entity.getDescription());

        return accounting;
    }

    public static List<Accounting> fromEntityStream(Stream<AccountingEntity> stream) {
        return stream
            .map(AccountingTransformations::fromEntity)
            .collect(Collectors.toList());
    }

    static AccountingEntity toEntity(Accounting accounting) {
        AccountingEntity entity = new AccountingEntity();
        entity.setId(accounting.getId());
        entity.setName(accounting.getName());
        entity.setDescription(accounting.getDescription());

        return entity;
    }
}
