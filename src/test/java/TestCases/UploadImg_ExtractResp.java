package TestCases;

import Config.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.awt.*;
import java.io.File;

import static io.restassured.RestAssured.*;
public class UploadImg_ExtractResp {

    public Response uploadImg(){
        File stesting = new File(System.getProperty("user.dir")+ "/src/test/resources/stesting.jpg");
        Response resp =
                given()
                        .pathParam("petId", 123)
                        .contentType(ContentType.fromContentType("multipart/form-data"))
                        //Method to add file
                        .multiPart("file",stesting)
                        .formParam("additionalMetadata", "data about the file")
                        .log().all().
                when()
                        .post(EndPoints.uploadImg).
                then()
                        .assertThat().statusCode(200)
                        .log().all()
                        .extract().response();
        return resp;
    }

}
