package TestCases;
import Config.EndPoints;
import POJOs.Add_UpdatePetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddPet_Post_bodyArray {

    public Response addingNewPet(){
        Add_UpdatePetPojo jsonFromPojo = new Add_UpdatePetPojo();

        Add_UpdatePetPojo.Category category = new Add_UpdatePetPojo.Category();
        category.setId(1);
        category.setName("bigDog");

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("www.photo1.petStore.com");
        photoUrls.add("www.photo2.petStore.com");

        Add_UpdatePetPojo.Tag tag1 = new Add_UpdatePetPojo.Tag();
        tag1.setId(1);
        tag1.setName("white");

        Add_UpdatePetPojo.Tag tag2 = new Add_UpdatePetPojo.Tag();
        tag2.setId(2);
        tag2.setName("first");

        List<Add_UpdatePetPojo.Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);

        Add_UpdatePetPojo body = new Add_UpdatePetPojo(123,category, "doggie1", photoUrls, tags,"available");

        Response resp =
                given()
                        .contentType(ContentType.JSON)
                        .body(body).
                when()
                        .post(EndPoints.addNewPet).
                then()
                        .assertThat().statusCode(200)
                        .log().all().extract().response();
        return resp;
    }
}
