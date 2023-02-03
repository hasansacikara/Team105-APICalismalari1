package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.*;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {

    public void delete01(){
       // request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        //response body’sinin null oldugunu test edin

        // 1 - URL ve body hazirligi

        specJsonPlace.pathParams("pp1","posts","pp2",50);

        // 2 - Expected Data hazirla
        // 3 - Response'u kaydet

        Response response = given().
                spec(specJsonPlace).
                when().
                delete("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                body("body",nullValue());
    }
}