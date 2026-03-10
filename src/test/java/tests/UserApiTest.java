package tests;

import base.BaseTest;
import client.UserApiClient;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.response.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

@Epic("API Demo Framework")
@Feature("User API")
public class UserApiTest extends BaseTest {
    private final UserApiClient userApiClient = new UserApiClient();

    @Test
    @Story("Get users")
    @Description("Verify that GET /users returns a non empty list of users")
    public void getUsersShouldReturnUserList() {
        Response response = userApiClient.getUsers();
        response.then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue())
                .body("[0].email", notNullValue())
                .body("[0].name", notNullValue());
    }

    @Test
    @Story("Create user")
    @Description("Verify that POST /users creates a user and returns generated id")
    public void createUserShouldReturnCreatedUser() {
        CreateUserRequest request = new CreateUserRequest(
                "Roman",
                "roman@examle.com"
        );
        CreateUserResponse response = userApiClient.createUser(request);
        Assert.assertNotNull(response.getId(), "User id should not be null");
        Assert.assertEquals(response.getName(), "Roman", "User name mismatch");
        Assert.assertEquals(response.getEmail(), "roman@examle.com", "User email mismatch");
    }

    @Test
    @Story("Get non-existing user")
    @Description("Verify that GET /users/{id} returns 404 for a missing user")
    public void getNonExistingUserShouldReturn404() {
        Response response = userApiClient.getUserById(99999);
        response.then()
                .statusCode(404);
    }
}
