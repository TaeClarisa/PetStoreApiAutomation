package Config;

import TestCases.AddPet_Post_bodyArray;
import TestCases.GetPet;
import TestCases.UpdatePet_Put_bodyArray;
import TestCases.UploadImg_ExtractResp;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class TestSuite {

    private static final String baseURI = "https://petstore.swagger.io";
    private static final String basePath = "/v2";
    private static final String bearerToken = "cb5abf80-4158-4e56-9146-f68220198bfb";
    private static final String apiKey = "special-key";

    @BeforeClass
    public static void testConfig(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setBasePath(basePath)
                .addHeader("api_key" ,apiKey)
                .addHeader("authorization","Bearer "+ bearerToken)
                .addHeader("accpet","application/json")
                .build();
    }

    /*create a complete request body as Pojo Class*/
    @Test
    public void addingNewPet(){
        AddPet_Post_bodyArray tc1 = new AddPet_Post_bodyArray();
        Response getResp= tc1.addingNewPet();
        String bodyAsString = getResp.getBody().asString();
        System.out.println(bodyAsString);
        String petName = "doggie1";
        String tagName1= "white";
        String bodyTag = getResp.getBody().path("tags[0].name");
        System.out.println(bodyTag);
        Assert.assertTrue("Body not contains " + petName, bodyAsString.contains("doggie1"));
        Assert.assertEquals("TagName isn't" + tagName1, tagName1, bodyTag);
    }

    @Test
    public void gettingApetById(){
       // AddPet_Post_bodyArray tc2 = new AddPet_Post_bodyArray();
        //tc2.addingNewPet();
        GetPet tc2 = new GetPet();
        tc2.getPetById();
    }

    /*Upload a jpg file as parameter*/
    @Test
    public void uploadingJPGfile(){
        UploadImg_ExtractResp tc3 = new UploadImg_ExtractResp();
        Response getResp = tc3.uploadImg();
        System.out.println(getResp.toString());
        int i = getResp.statusCode();
        System.out.println(i);
    }

    /*PUT method*/
@Test
    public void updatingExistingPet(){
    UpdatePet_Put_bodyArray tc4=new UpdatePet_Put_bodyArray();
    Response getResp = tc4.updatingExistingPet();
    Integer i = getResp.statusCode();
   //Assert.assertTrue(i.toString().contains("200"));
    String petStatus ="sold";
    //String statusFromResponse = getResp.jsonPath().get("status");
    //Assert.assertEquals(petStatus,statusFromResponse);

    /*obtengo todos los valores de id que hay en Tags*/
    //String allTagsId = getResp.jsonPath().get("tags.id").toString();
    //System.out.println(allTagsId);
    //Assert.assertTrue(allTagsId.contains("2"));

    /*obtengo todos los valores de id que hay en Tags con una lista*/
   // System.out.println("***"+tc4.gettingTagsFromResp());


    tc4.gettingCoordsForTag();
   /* int tagsId = getResp.jsonPath().get("tags.id.size()"); //obtiene el tamaño
    System.out.println(tagsId);
    for (int j = 0; j < tagsId; j++) {
        String name = getResp.jsonPath().get("tags.name["+j+"]");
        System.out.println(j+" " +name);
    }*/


}


}
