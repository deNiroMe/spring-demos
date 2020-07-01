package ma.example.books.bookservice.it.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ma.example.books.bookservice.it.config.SpringIntegrationTest;

public class BooksControllerSteps extends SpringIntegrationTest {

    @When("the client calls \\/books")
    public void the_client_calls_books() {
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer int1) {
    }

    @Then("the client receives a list size {int} of books")
    public void the_client_receives_a_list_size_of_books(Integer int1) {
    }

}
