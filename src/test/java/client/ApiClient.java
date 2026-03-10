package client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private static final RequestSpecification REQUEST_SPEC = new RequestSpecBuilder()
            .addFilter(new AllureRestAssured())
            .setContentType("application/json")
            .build();

    public static RequestSpecification getRequestSpec() {
        return REQUEST_SPEC;
    }
}
