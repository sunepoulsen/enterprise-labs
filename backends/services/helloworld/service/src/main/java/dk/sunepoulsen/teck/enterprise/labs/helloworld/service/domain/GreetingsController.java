package dk.sunepoulsen.teck.enterprise.labs.helloworld.service.domain;

import dk.sunepoulsen.teck.enterprise.labs.helloworld.rs.client.model.Greetings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @RequestMapping(method = RequestMethod.GET, value = "/greetings")
    public Greetings getGreetings() {
        Greetings greetings = new Greetings();
        greetings.setMessage("Hello World");

        return greetings;
    }
}
