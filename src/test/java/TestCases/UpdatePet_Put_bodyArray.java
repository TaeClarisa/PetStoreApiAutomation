package TestCases;
import Config.EndPoints;
import POJOs.Add_UpdatePetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePet_Put_bodyArray {

    public Response updatingExistingPet(){
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

        Add_UpdatePetPojo body = new Add_UpdatePetPojo(123,category, "doggie1", photoUrls, tags,"sold");

        Response resp =
                given()
                        .contentType(ContentType.JSON)
                        .body(body).
                when()
                        .put(EndPoints.updatePet).
                then()
                        .assertThat().statusCode(200)
                        .log().all().extract().response();
        return resp;
    }

  public List<String> gettingTagsFromResp(){
        Response getResponse = updatingExistingPet();
        String getResponseAsString = updatingExistingPet().toString();
        List<Integer> allTagsId = (getResponse.jsonPath().get("tags.id"));
        List<String> tagsID = new ArrayList<>();
        for (Integer oneTag:allTagsId
             ) {
        tagsID.add(String.valueOf(oneTag));
        }
        return tagsID;
    }
    public Map<Integer,String> gettingCoordsForTag(){
        Response getResp = updatingExistingPet();
        Map<Integer,String> id_name = new HashMap<>();
        int tagsIdSize = getResp.jsonPath().get("tags.id.size()"); //obtiene el tamaño
        System.out.println(tagsIdSize);
        for (int j = 0; j < tagsIdSize; j++) {
            String name = getResp.jsonPath().get("tags.name["+j+"]");
            id_name.put(j,name);
            System.out.println(j+" " +name);
        }
        System.out.println(id_name);
        return id_name;

    }

}
