import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UpdateAsync_Test {
    String lenderCode = "TRP";
    String lenderCodeWrong = "XXXsdf";

    @DisplayName("Status Code 200. All parameters are correct. contentType.JSON checking.")
    @Order(1)
    @Test
    public void UpdateAsync_Test_1_AllRight_Code200_contentTypeJSON() {
        JSONObject innerParams = new JSONObject();
        innerParams.put("documentTypeId", "44570b9f-3c7f-4b4b-8be5-850527951182");
        innerParams.put("orderNumber", 0);
        JSONArray ja = new JSONArray();
        ja.put(innerParams);
        JSONObject requestParams = new JSONObject();
        requestParams.put("documentSetId", "2ac3fe05-a4ea-4aa1-a363-07f47e1e23e6");
        requestParams.put("isDeleted", true);
        requestParams.put("documentTypes", ja);
        System.out.println(requestParams);
        given().
                header("Content-Type", "application/json").
                body(requestParams.toString()).
                when().
                put("https://qa-api-v2.ilendingdirect.com/document-service/documentset/" + lenderCode).
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }

    @DisplayName("Status Code 404. 'lenderCode' is missed.")
    @Order(2)
    @Test
    public void UpdateAsync_Test_2_Missed_lenderCode_Code404() {
        JSONObject innerParams = new JSONObject();
        innerParams.put("documentTypeId", "44570b9f-3c7f-4b4b-8be5-850527951182");
        innerParams.put("orderNumber", 0);
        JSONArray ja = new JSONArray();
        ja.put(innerParams);
        JSONObject requestParams = new JSONObject();
        requestParams.put("documentSetId", "2ac3fe05-a4ea-4aa1-a363-07f47e1e23e6");
        requestParams.put("isDeleted", true);
        requestParams.put("documentTypes", ja);
        given().
                header("Content-Type", "application/json").
                body(requestParams.toString()).
                when().
                put("https://qa-api-v2.ilendingdirect.com/document-service/documentset/").
                then().
                assertThat().
                statusCode(404);
    }

    @DisplayName("Status Code 400. 'lenderCode' is wrong.")
    @Order(3)
    @Test
    public void UpdateAsync_Test_3_Wrong_lenderCode_Code400() {
        JSONObject innerParams = new JSONObject();
        innerParams.put("documentTypeId", "44570b9f-3c7f-4b4b-8be5-850527951182");
        innerParams.put("orderNumber", 0);
        JSONArray ja = new JSONArray();
        ja.put(innerParams);
        JSONObject requestParams = new JSONObject();
        requestParams.put("documentSetId", "2ac3fe05-a4ea-4aa1-a363-07f47e1e23e6");
        requestParams.put("isDeleted", true);
        requestParams.put("documentTypes", ja);
        given().
                header("Content-Type", "application/json").
                body(requestParams.toString()).
                when().
                put("https://qa-api-v2.ilendingdirect.com/document-service/documentset/" + lenderCodeWrong).
                then().
                assertThat().
                statusCode(400);
    }

}
