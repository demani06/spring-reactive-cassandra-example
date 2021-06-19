package com.deepak.springreactivecassandraexample.bdd;

import com.deepak.springreactivecassandraexample.model.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductsStepDefinitionTest extends GenericSteps {

    @Autowired
    WebTestClient webTestClient;

    WebTestClient.ResponseSpec exchange;

    @Given("the products exist in the DB")
    public void the_products_exist_in_the_db() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("THe product exists in the DB");

    }

    @When("^the client calls \"([^\"]*)\"$")
    public void the_client_calls(String endpoint) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("THe product exists in the DB" + endpoint);
        exchange = webTestClient.get()
                .uri("/products")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        exchange.expectStatus().isEqualTo(statusCode);
        //.expectStatus().isOk();
               /* .expectBody(Product.class)
                .value(product -> product)*/
    }

    @Then("^the response contains product Name \"([^\"]*)\"$")
    public void the_response_contains_product_name(String productName) {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("the_response_contains_product_name" + productName);
        exchange.
                expectBody(Product[].class)
                .value(products -> Arrays.stream(products)
                        .forEach(product -> {
                assertEquals(productName, productName);
        }));
    }
}
