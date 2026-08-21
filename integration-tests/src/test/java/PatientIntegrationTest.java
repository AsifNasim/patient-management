import io.restassured.RestAssured;
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
