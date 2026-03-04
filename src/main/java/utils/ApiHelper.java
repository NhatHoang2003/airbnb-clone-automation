package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static final String BASE_URL = "https://abc.com";

    public static String loginAndGetToken(String email, String password) {

        RestAssured.baseURI = BASE_URL;

        Response response =
                given()
                        .contentType("application/json")
                        .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                        .when()
                        .post("/api/auth/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        return response.path("token");
    }
}