package dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.ct;

import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.exceptions.ClientBadRequestException;
import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.exceptions.ClientConflictException;
import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.exceptions.ClientNotFoundException;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.AccountingIntegrator;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.rs.client.model.AccountingPagination;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.Application;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.accountings.AccountingTransformations;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence.AccountingEntity;
import dk.sunepoulsen.tech.enterprise.labs.mycash.accounting.service.domain.persistence.AccountingRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceComponentTest {
    @LocalServerPort
    private int serverPort;

    @Autowired
    private AccountingRepository repository;

    private AccountingIntegrator integrator;

    @Before
    public void setupIntegrator() throws Exception {
        this.integrator = new AccountingIntegrator(new TechEnterpriseLabsClient(new URI("http://localhost:" + serverPort)));
        repository.deleteAll();
    }

    @Test
    public void testCreateAccounting_Success() throws Exception {
        Accounting newAccounting = new Accounting();
        newAccounting.setName("name");
        newAccounting.setDescription("description");

        Accounting createdAccounting = this.integrator.createAccounting(newAccounting).blockingGet();
        assertThat(createdAccounting.getId(), notNullValue());

        newAccounting.setId(createdAccounting.getId());
        assertThat(newAccounting, equalTo(createdAccounting));

        Optional<AccountingEntity> optionalAccountingEntity = repository.findById(createdAccounting.getId());
        assertThat(optionalAccountingEntity.isEmpty(), equalTo(false));
        MatcherAssert.assertThat(newAccounting, equalTo(AccountingTransformations.fromEntity(optionalAccountingEntity.get())));
    }

    @Test(expected = ClientBadRequestException.class)
    public void testCreateAccounting_BadRequest() throws Exception {
        this.integrator.createAccounting(new Accounting()).blockingGet();
    }

    @Test(expected = ClientConflictException.class)
    public void testCreateAccounting_Conflict() throws Exception {
        Accounting newAccounting = new Accounting();
        newAccounting.setName("name");
        newAccounting.setDescription("description");

        this.integrator.createAccounting(newAccounting).blockingGet();
        this.integrator.createAccounting(newAccounting).blockingGet();
    }

    @Test
    public void testGetAccounting_Success() throws Exception {
        // Given
        Accounting newAccounting = new Accounting();
        newAccounting.setName("name");
        newAccounting.setDescription("description");

        Accounting createdAccounting = this.integrator.createAccounting(newAccounting).blockingGet();

        // When
        Accounting actual = this.integrator.getAccounting(createdAccounting.getId()).blockingGet();

        // Then
        Accounting expected = new Accounting();
        expected.setId(createdAccounting.getId());
        expected.setName(newAccounting.getName());
        expected.setDescription(newAccounting.getDescription());
        assertThat(actual, equalTo(expected));
    }

    @Test(expected = ClientNotFoundException.class)
    public void testGetAccounting_NotFound() throws Exception {
        this.integrator.getAccounting(25L).blockingGet();
    }

    @Test
    public void testGetAccountings_NoAccountingsExist_Success() throws Exception {
        // When
        AccountingPagination actual = this.integrator.getAccountings(0, 10).blockingGet();

        // Then
        AccountingPagination expected = new AccountingPagination();
        expected.setPage(0);
        expected.setTotalPages(0);
        expected.setTotalItems(0);
        expected.setResults(Collections.emptyList());

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testGetAccountings_AccountingsFromFirstPage_Success() throws Exception {
        // Given
        List<AccountingEntity> accountingEntities = createAccountingsInDatabase(10);

        // When
        AccountingPagination actual = this.integrator.getAccountings(0, 10).blockingGet();

        // Then
        List<Accounting> accountings = createAccountings(0, 10, accountingEntities);

        AccountingPagination expected = new AccountingPagination();
        expected.setPage(0);
        expected.setTotalPages(1);
        expected.setTotalItems(10);
        expected.setResults(accountings);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testGetAccountings_AccountingsFromMiddlePage_Success() throws Exception {
        // Given
        List<AccountingEntity> accountingEntities = createAccountingsInDatabase(95);

        // When
        AccountingPagination actual = this.integrator.getAccountings(5, 10).blockingGet();

        // Then
        List<Accounting> accountings = createAccountings(50, 10, accountingEntities);

        AccountingPagination expected = new AccountingPagination();
        expected.setPage(5);
        expected.setTotalPages(10);
        expected.setTotalItems(95);
        expected.setResults(accountings);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testGetAccountings_AccountingsFromLastPage_Success() throws Exception {
        // Given
        List<AccountingEntity> accountingEntities = createAccountingsInDatabase(95);

        // When
        AccountingPagination actual = this.integrator.getAccountings(9, 10).blockingGet();

        // Then
        List<Accounting> accountings = createAccountings(90, 5, accountingEntities);

        AccountingPagination expected = new AccountingPagination();
        expected.setPage(9);
        expected.setTotalPages(10);
        expected.setTotalItems(95);
        expected.setResults(accountings);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testPatchAccounting_Success() throws Exception {
        // Given
        Accounting existingAccounting = new Accounting();
        existingAccounting.setName("name");
        existingAccounting.setDescription("description");

        existingAccounting = this.integrator.createAccounting(existingAccounting).blockingGet();

        // When
        Accounting patchAccounting = new Accounting();
        patchAccounting.setDescription("New description");

        Accounting actual = this.integrator.updateAccounting(existingAccounting.getId(), patchAccounting).blockingGet();

        // Then
        Accounting expected = new Accounting();
        expected.setId( existingAccounting.getId());
        expected.setName( existingAccounting.getName());
        expected.setDescription( patchAccounting.getDescription());

        assertThat(actual, equalTo(expected));
        Optional<AccountingEntity> optionalAccountingEntity = repository.findById(actual.getId());
        assertThat(optionalAccountingEntity.isEmpty(), equalTo(false));
        MatcherAssert.assertThat(expected, equalTo(AccountingTransformations.fromEntity(optionalAccountingEntity.get())));
    }

    private List<AccountingEntity> createAccountingsInDatabase(int count) {
        List<AccountingEntity> entities = new ArrayList<>();

        for( int i = 1; i <= count; i++) {
            AccountingEntity entity = new AccountingEntity();
            entity.setName("Name " + i);
            entity.setDescription("Description " + i);

            entities.add(repository.save(entity));
        }

        return entities;
    }

    private List<Accounting> createAccountings(int startIndex, int count, List<AccountingEntity> accountingEntities) {
        List<Accounting> list = new ArrayList<>();

        for( int i = 0; i < count; i++) {
            int number = startIndex + 1 + i;

            Accounting accounting = new Accounting();
            if( i + startIndex < accountingEntities.size() ) {
                accounting.setId(accountingEntities.get(i + startIndex).getId());
            }
            accounting.setName("Name " + number);
            accounting.setDescription("Description " + number);

            list.add(accounting);
        }

        return list;
    }
}
