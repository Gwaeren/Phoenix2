import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;

public class GetAllAsync_Test {

    @DisplayName("getAllAsync")
    @Test
    public void getAllAsync_Test_1_AllRight_Code200_contentTypeJSON() {
        given().
                when().
                get("https://qa-api-v2.ilendingdirect.com/lender-service/lenders").
                then().
                assertThat().
                body("[0].code", equalTo("Blm")).
                and().
                body("[1].code", equalTo("Blr"));
//                contentType(ContentType.JSON).
//                statusCode(200);
    }

}
