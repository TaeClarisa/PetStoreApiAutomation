package Config;

public interface EndPoints {
    String uploadImg = "/pet/{petId}/uploadImage";
    String addNewPet = "/pet";
    String getPetById = "/pet/{petId}";
    String updatePet = "/pet";

}
