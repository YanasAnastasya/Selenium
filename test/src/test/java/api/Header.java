package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.lessThan;

public class Header {
    private final static String URL = "";

    @Test
    public void validateTimeSecondsSuccess() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        RestAssured.given()
                .when()
                .get("")
                .then().log().all()
                .time(lessThan(5000L));
    }

    @Test
    public void checkSearchEmptyRootNotNull() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        Response response = RestAssured.given()
                .when()
                .get("")
                .then().log().all()
                .body("d{ it.p }.", notNullValue())
                .body("d.find { it.id }.id", notNullValue())
                .extract().response();
    }

    @Test
    public void checkSearchTypes() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        Response response = RestAssured.given()
                .when()
                .get("")
                .then().log().all()
                .body("d.find { it.p }.p", isA(String.class))
                .extract().response();
    }

    @Test
    public void checkSearchDocumentsTitle() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        RestAssured.given()
                .get("Ç")
                .then().log().all()
                .assertThat()
                .body("d.find { it.p }.p", containsString("¹"));
    }
}
