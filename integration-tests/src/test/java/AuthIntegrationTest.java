import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI="http://localhost:4004";

    }

    @Test
    public void shouldReturnOKWithValidToken(){
//        Arrange - arrange any setup that this test is required, to make the setup work 100%

        String loginPayLoad = """
                {
                "email":"testuser@test.com",
                "password":"password123"
                }
                """;
//        Act - Act on a test

        Response response = given()
                .contentType("application/json")
                .body(loginPayLoad)
                .when()
                .post("/auth/login")
                .then()
//        Assert - assert the response - in this case match the auth token
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token: "+ response.jsonPath().getString("token"));
//        Assert - assert the response - in this case math the auth token

    }
    @Test
    public void shouldReturnUnAuthorizedOnInValidToken(){
//        Arrange - arrange any setup that this test is required, to make the setup work 100%

        String loginPayLoad = """
                {
                "email":"invallid@test.com",
                "password":"wrongpassword"
                }
                """;
//        Act - Act on a test

        given()
                .contentType("application/json")
                .body(loginPayLoad)
                .when()
                .post("/auth/login")
                .then()
//        Assert - assert the response - in this case match the auth token
                .statusCode(401);


    }




}
