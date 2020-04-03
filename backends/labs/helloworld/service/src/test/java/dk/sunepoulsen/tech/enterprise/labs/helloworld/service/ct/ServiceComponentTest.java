package dk.sunepoulsen.tech.enterprise.labs.helloworld.service.ct;

import dk.sunepoulsen.tech.enterprise.labs.core.rs.client.TechEnterpriseLabsClient;
import dk.sunepoulsen.tech.enterprise.labs.helloworld.rs.client.HelloWorldIntegrator;
import dk.sunepoulsen.tech.enterprise.labs.helloworld.rs.client.model.Greetings;
import dk.sunepoulsen.tech.enterprise.labs.helloworld.service.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceComponentTest {
    @LocalServerPort
    private int serverPort;

    private HelloWorldIntegrator integrator;

    @Before
    public void setupIntegrator() throws Exception {
        this.integrator = new HelloWorldIntegrator(new TechEnterpriseLabsClient(new URI("http://localhost:" + serverPort)));
    }

    @Test
    public void testGetGreetings_OK() throws Exception {
        Greetings expected = new Greetings();
        expected.setMessage("Hello World");

        assertThat(integrator.greetings().blockingGet(), equalTo(expected));
    }
}
