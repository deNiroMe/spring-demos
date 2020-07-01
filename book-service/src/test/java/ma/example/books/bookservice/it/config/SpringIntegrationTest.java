package ma.example.books.bookservice.it.config;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import ma.example.books.BookServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = BookServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    @Before
    public void setup_cucumber_spring_context(){
        log.debug("before starting cucumber");
    }

}
