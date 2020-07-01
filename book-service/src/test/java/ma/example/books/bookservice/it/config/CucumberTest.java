package ma.example.books.bookservice.it.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"cucumber.api.spring",
                "ma.example.books.bookservice.it"})
public class CucumberTest { }
