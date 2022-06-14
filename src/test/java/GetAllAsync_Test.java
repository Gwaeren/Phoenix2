import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetAllAsync_Test {

    @DisplayName("Status Code 200. ContentType.JSON.")
    @Order(1)
    @Test
    public void getAllAsync_Test_1_AllRight_Code200_contentTypeJSON() {
        given().
                when().
                get("https://qa-api-v2.ilendingdirect.com/lender-service/lenders").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }

    @DisplayName("Status Code 200. Uppercase letters at '/LENDERS' part.")
    @Order(2)
    @Test
    public void getAllAsync_Test_2_UppercaseLetters_Code200_contentTypeJSON() {
        String upperLenders = "LENDERS";
        given().
                when().
                get("https://qa-api-v2.ilendingdirect.com/lender-service/" + upperLenders).
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }

    @DisplayName("Status Code 401. Wrong '/lenders_xxx' part")
    @Order(3)
    @Test
    public void getAllAsync_Test_3_WrongLenders_Code404() {
        String wrongLenders = "lenders_xxx";
        given().
                when().
                get("https://qa-api-v2.ilendingdirect.com/lender-service/" + wrongLenders).
                then().
                assertThat().
                statusCode(404);
    }

}
