package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeesApiTests extends BaseEmployeesControllerTest {

    @Test
    public void printAllEmployees() {
        Response response = given()
                .log().uri().
                when().
                get("/employees").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void printEmployee() {
        Response response = given()
                .log().uri().
                when().
                get("/employee/{id}", "8370").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
//                        body("data.employee_name",
//                                equalTo("Automation Test")).
        extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void createEmployee() {
        Response response = given()
                .log().uri().
                contentType(ContentType.JSON).
                body("{\"employee_name\":\"Automation Test\"," +
                        "\"employee_salary\":\"123\"," +
                        "\"employee_age\":\"35\", " +
                        "\"profile_image\":\"\"}").
                when().
                post("/create").
                then().
                statusCode(200).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void updateEmployee() {
        Response response = given()
                .log().uri().
                contentType(ContentType.JSON).
                body("{\"employee_name\":\"Automation Test\"," +
                        "\"employee_salary\":\"123\"," +
                        "\"employee_age\":\"40\", " +
                        "\"profile_image\":\"\"}").
                when().
                put("/update/{id}", "7177").
                then().
                statusCode(200).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void deleteEmployee() {
        Response response = given()
                .log().uri().
                contentType(ContentType.JSON).
                when().
                get("/delete/{id}", "8370").
                then().
                extract().response();
        response.getBody().prettyPrint();
        response = given()
                .log().uri().
                when().
                get("/employee/{id}", "8370").
                then().
//                        statusCode(404).
        contentType(ContentType.JSON).
                extract().response();
        response.getBody().prettyPrint();
    }
}