import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UploadAsync_Test {

    String documentTypeId = "76ded7a5-64f1-4c45-8cf7-3d877e6fa900";

    public static Object[][] testData_1() {
        return new Object[][] {
                { "TRP", "76ded7a5-64f1-4c45-8cf7-3d877e6fa900" },
        };
    }
    public static Object[][] testData_2() {
        return new Object[][] {
                { "TRP", "76ded7a5-64f1-4c45-8cf7-3d877e6fa900_XXX" },
        };
    }
    public static Object[][] testData_3() {
        return new Object[][] {
                { "TRP_XXX", "76ded7a5-64f1-4c45-8cf7-3d877e6fa900" }
        };
    }

    File file = new File("C:\\Users\\User\\Downloads\\Telegram Desktop\\PdfSample.pdf");

    @DisplayName("Status Code 200. All parameters are correct. contentTypeJSON checking.")
    @Order(1)
    @ParameterizedTest
    @MethodSource("testData_1")
    public void UploadAsync_Test_1_AllRight_Code200_contentTypeJSON(String lenderCode, String documentTypeId) {
        given().
                pathParam("lenderCode", lenderCode).pathParam("documentTypeId", documentTypeId).
                multiPart("file", file, "multipart/form-data").
                when().
                post("https://qa-api-v2.ilendingdirect.com/document-service/lenders/{lenderCode}/document-types/{documentTypeId}/documents").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }

    @DisplayName("Status Code 404. 'documentTypeId' is wrong.")
    @Order(2)
    @ParameterizedTest
    @MethodSource("testData_2")
    public void UploadAsync_Test_2_Wrong_documentTypeId_Code404(String lenderCode, String documentTypeId) {
        given().
                pathParam("lenderCode", lenderCode).pathParam("documentTypeId", documentTypeId).
                multiPart("file", file, "multipart/form-data").
                when().
                post("https://qa-api-v2.ilendingdirect.com/document-service/lenders/{lenderCode}/document-types/{documentTypeId}/documents").
                then().
                assertThat().
                statusCode(404);
    }

    @DisplayName("Status Code 404. 'lenderCode' is wrong. 'body' and 'code' values checking.")
    @Order(3)
    @ParameterizedTest
    @MethodSource("testData_3")
    public void UploadAsync_Test_3_Wrong_lenderCode_Code404_MessageAndCode_Checking(String lenderCode, String documentTypeId) {
        given().
                pathParam("lenderCode", lenderCode).pathParam("documentTypeId", documentTypeId).
                multiPart("file", file, "multipart/form-data").
                when().
                post("https://qa-api-v2.ilendingdirect.com/document-service/lenders/{lenderCode}/document-types/{documentTypeId}/documents").
                then().
                assertThat().
                statusCode(404).
                body("message", equalTo("Entity type of Phoenix2.DocumentService.Domain.Entities.DocumentType with id '" + documentTypeId + "' not found")).
                body("code", equalTo("NotFound"));
    }

    @DisplayName("Status Code 400. File is missed. 'title' and 'errors'.File[0]' values checking.")
    @Order(4)
    @ParameterizedTest
    @MethodSource("testData_1")
    public void UploadAsync_Test_5_Missed_File_Code400_TitleAndErrorsFile_Checking(String lenderCode, String documentTypeId) {
        given().
                pathParam("lenderCode", lenderCode).pathParam("documentTypeId", documentTypeId).
                when().
                post("https://qa-api-v2.ilendingdirect.com/document-service/lenders/{lenderCode}/document-types/{documentTypeId}/documents").
                then().
                assertThat().
                statusCode(400).
                body("title", equalTo("One or more validation errors occurred.")).
                body("'errors'.File[0]", equalTo("The File field is required."));
    }
}
