package parallel;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs {

    @Given("^Login to application$")
    public void login_to_application() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Login Step executed");

    }

    @When("^Step (\\d+)$")
    public void step(int arg0) {
        System.out.println("Step :"+arg0);
    }
}

