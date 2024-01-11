package TestCases;

import Config.EndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPet {

    public Response getPetById(){
        Response resp =
                given()
                        .pathParam("petId", 123)
                        .log().all().
                when()
                       .get(EndPoints.getPetById).
                then()
                        .assertThat().statusCode(200)
                        .log().all()
                        .extract().response();
        return resp;
    }
}
