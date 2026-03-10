package client;

import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UserApiClient {
    public Response getUsers() {
        return given()
                .spec(ApiClient.getRequestSpec())
        .when()
                .get("/users");
    }

    public Response getUserById(int userId) {
        return given()
                .spec(ApiClient.getRequestSpec())
        .when()
                .get("/users/" + userId);
    }

    public CreateUserResponse createUser(CreateUserRequest request) {
        return given()
                .spec(ApiClient.getRequestSpec())
                .body(request)
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .extract()
                .as(CreateUserResponse.class);
    }
}
