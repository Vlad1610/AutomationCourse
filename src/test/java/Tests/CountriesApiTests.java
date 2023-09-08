package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class CountriesApiTests extends BaseCountriesControllerTest {

    @Test
    public void getCountryByName() {
        Response response = given()
                .log().uri().
                when().
                get("/name/{name}", "rom").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("name.official[0]",
                        equalTo("Romania")).
                body("currencies.RON.symbol[0]",
                        equalTo("lei")).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void verifyCountriesCapital() {
        given()
                .log().uri().
                when().
                queryParam("fullText", true).
                get("/name/{name}", "romania").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("capital[0][0]", equalTo("Bucharest")).
                extract().response();
    }

    @Test
    public void verifyAltSpelling() {
        given()
                .log().uri().
                when().
                queryParam("fullText", true).
                get("/name/{name}", "romania").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("altSpellings[0]", hasItem("România")).
                extract().response();
    }

    @Test
    public void verifyCountryBorders() {
        List<String> expectedBorders = Arrays.asList(
                "MDA", "BGR", "HUN", "SRB", "UKR");
        List<String> actualBorders = new ArrayList<>(given()
                .log().uri().
                when().
                queryParam("fullText", true).
                get("/name/{name}", "romania").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().response().jsonPath().getList("borders[0]",
                        String.class));
        expectedBorders.sort(Comparator.naturalOrder());
        actualBorders.sort(Comparator.naturalOrder());
        Assert.assertEquals(expectedBorders, actualBorders);
    }
}