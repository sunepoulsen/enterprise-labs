package dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.domain.accountings;

import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.domain.persistence.AccountingEntity;

public class AccountingTransformations {
    public static Accounting fromEntity(AccountingEntity entity) {
        Accounting accounting = new Accounting();
        accounting.setId(entity.getId());
        accounting.setName(entity.getName());
        accounting.setDescription(entity.getDescription());

        return accounting;
    }

    static AccountingEntity toEntity(Accounting accounting) {
        AccountingEntity entity = new AccountingEntity();
        entity.setId(accounting.getId());
        entity.setName(accounting.getName());
        entity.setDescription(accounting.getDescription());

        return entity;
    }
}
