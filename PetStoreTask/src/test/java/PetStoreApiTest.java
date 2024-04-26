import io.restassured.RestAssured;
import org.example.PetStore.Pet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetStoreApiTest {

    Pet petJson ;
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final int PET_ID = 10; // Example pet ID for GET, PUT, DELETE

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test(priority = -1)
    public void testAddPet_POST() {
        petJson = new Pet();
        petJson.setId(PET_ID);
        petJson.setName("Fluffy");
        petJson.setStatus("available"); // Or "pending", "sold"

// Set category (optional)
        Pet.Category category = new Pet.Category();
        category.setId(1); // Replace with category ID
        category.setName("Cat");
        petJson.setCategory(category);

// Set tags (optional)
        List<Pet.Tag> tags = new ArrayList<>();
        Pet.Tag tag1 = new Pet.Tag();
        tag1.setId(1); // Replace with desired ID
        tag1.setName("cute");
        tags.add(tag1);
        petJson.setTags(tags);

// Set photoUrls (optional)
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/pet1.jpg");
        petJson.setPhotoUrls(photoUrls);

        RestAssured.given()
                .contentType("application/json") // Set content type for POST
                .body(petJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 0)    public void testGetPetById_GET() {
        RestAssured.given()
                .when()
                .get("/pet/" + PET_ID)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 1)
    public void testUpdatePet_PUT() {
        petJson.setId(12); // Replace with desired ID
        RestAssured.given()
                .contentType("application/json")
                .body(petJson)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 2)
    public void testDeletePet_DELETE() {
        petJson.setId(12); // Replace with desired ID
        RestAssured.given()
                .when()
                .delete("/pet/" + PET_ID)
                .then()
                .statusCode(200)
                .log().body();
    }
}
