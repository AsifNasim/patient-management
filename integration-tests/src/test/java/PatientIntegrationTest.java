import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PatientIntegrationTest {

//     Before all the tests in the class
    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnPatientsWithValidToken(){

//        Arrange
//        eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlckB0ZXN0LmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc4NzI5NTc3NCwiZXhwIjoxNzg3MzMxNzc0fQ.oYqOfZcGqOZeWtE6mXaASBXUZqz5DLi4kNkkjHuw1oo

//        Arrange - arrange any setup that this test is required, to make the setup work 100%

                String loginPayLoad = """
                {
                "email":"testuser@test.com",
                "password":"password123"
                }
                """;
//        Act - Act on a test

        String token = given()
                .contentType("application/json")
                .body(loginPayLoad)
                .when()
                .post("/auth/login")
                .then()
//        Assert - assert the response - in this case match the auth token
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/patients/all")
                .then()
                .statusCode(200)
                .body("patients", notNullValue());





    }
}
