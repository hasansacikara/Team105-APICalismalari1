package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */

    @Test
    public void post01(){

        // 1- URL ve body hazırla

        String url ="    https://restful-booker.herokuapp.com/booking";

        JSONObject innerJsonObje = new JSONObject();
        innerJsonObje.put("checkin","2021-06-01");
        innerJsonObje.put("checkout","2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerJsonObje);
        reqBody.put("additionalneeds" , "wi-fi");

        //2- Expected Data hazırla

        JSONObject expBody = new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        // 3- Response'i kaydet

        Response response= given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);

        System.out.println("response = ");
                response.prettyPrint();

                // 4- Assertion

        JsonPath reJsonPath = response.jsonPath();

        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),reJsonPath.get("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),reJsonPath.get("booking.lastname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),reJsonPath.get("booking.additionalneeds"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("totalprice"),reJsonPath.get("booking.totalprice"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("depositpaid"),reJsonPath.get("booking.depositpaid"));



    }
}
