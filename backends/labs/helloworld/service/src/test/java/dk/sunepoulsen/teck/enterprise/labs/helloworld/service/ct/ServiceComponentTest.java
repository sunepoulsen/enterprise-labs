package dk.sunepoulsen.teck.enterprise.labs.helloworld.service.ct;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sunepoulsen.teck.enterprise.labs.core.rs.client.generators.UUIDRequestIdGenerator;
import dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client.model.Greetings;
import dk.sunepoulsen.teck.enterprise.labs.helloworld.service.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ServiceComponentTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetGreetings_OK() throws Exception {
        Greetings expected = new Greetings();
        expected.setMessage("Hello World");

        mvc.perform(MockMvcRequestBuilders.get("/greetings")
            .header("X-Request-ID", new UUIDRequestIdGenerator().generateId())
        )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected)));
    }
}
