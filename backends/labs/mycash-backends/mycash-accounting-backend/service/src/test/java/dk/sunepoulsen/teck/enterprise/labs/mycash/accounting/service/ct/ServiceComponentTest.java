package dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.ct;

import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.exceptions.ClientException;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.exceptions.ClientNotImplementedException;
import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client.AccountingIntegrator;
import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.rs.client.model.Accounting;
import dk.sunepoulsen.teck.enterprise.labs.mycash.accounting.service.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ServiceComponentTest {
    @LocalServerPort
    private int serverPort;

    private AccountingIntegrator integrator;

    @Before
    public void setupIntegrator() throws Exception {
        this.integrator = new AccountingIntegrator(new TechEnterpriseLabsClient(new URI("http://localhost:" + serverPort)));
    }

    @Test(expected = ClientNotImplementedException.class)
    public void testCreateAccounting_OK() throws Exception {
        Accounting newAccounting = new Accounting();
        newAccounting.setName("name");
        newAccounting.setDescription("description");

        this.integrator.createAccounting(newAccounting).blockingGet();
    }
}
