import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.json.Json;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateAsync_Test {

// This test will be failed at any cases, cos. should be specified for exact "Lender Code"
    @DisplayName("Status Code 200. ContentType.JSON.")
    @Order(1)
    @Test
    public void CreateAsync_Test_1_AllRight_Code200_contentTypeJSON() {
        String a = "KbbRetail";
        JSONArray jsa = new JSONArray();
        jsa.put(a);
        JSONObject b = new JSONObject();
        b.put("generalInfo", jsa);
        b.put("daysToFirstPaymentGreen", 0);
        b.put("daysToFirstPaymentYellow", 0);
        b.put("maxDtiGreen", 0);
        b.put("maxDtiYellow", 0);
        b.put("maxPtiGreen", 0);
        b.put("maxPtiYellow", 0);
        b.put("availableMarkupIncrements", "string");
        b.put("maxMileageGreen", 0);
        b.put("maxMileageYellow", 0);
        b.put("maxAgeGreen", 0);
        b.put("maxAgeYellow", 0);
        b.put("minPrimaryFicoGreen", 0);
        b.put("minPrimaryFicoYellow", 0);
        b.put("minSecondaryFicoGreen", 0);
        b.put("minSecondaryFicoYellow", 0);
        b.put("approvalDaysGreen", 0);
        b.put("approvalDaysYellow", 0);
        b.put("maxCashOutGreen", 0);
        b.put("maxCashOutYellow", 0);
        b.put("maxFlatPercentGreen", 0);
        b.put("maxFlatPercentYellow", 0);
        b.put("maxGapGreen", 0);
        b.put("maxGapYellow", 0);
        b.put("gapLtvLimit", 0);
        b.put("maxFlatGreen", 0);
        b.put("maxFlatYellow", 0);
        b.put("flatPercent", 0);
        b.put("maxOtherProducts", 0);
        b.put("experianDefaultScore", "Eqf");
        b.put("secondaryBureau", "Eqf");
        b.put("primaryBureau", "Eqf");
        b.put("fundingFeeGreen", 0);
        b.put("fundingFeeYellow", 0);
        b.put("allowEmployerZip", true);
        b.put("statedFunds", 0);
        b.put("expectedFunds", 0);
        b.put("achDiscount", 0);
        b.put("maxVsc", 0);
        b.put("maxProduct", 0);
        b.put("requirements", "string");
        b.put("useAprBasedCalculation", 0);
        b.put("contractDateForUsingAprBasedCalculations", "2022-06-14T11:02:32.566Z");
        b.put("maxVrp", 0);
        b.put("creditReport", "Eqf");
        JSONObject c = new JSONObject();
        c.put("name", "string");
        c.put("address", "string");
        c.put("state", "AL");
        c.put("postCode", "12345");
        c.put("contactPerson", "string");
        c.put("contactPhone", "1234567890");
        c.put("city", "string");
        c.put("code", "string");
        c.put("rank", 1);
        c.put("ltvType", "FrontEnd");
        c.put("useBothLtv", true);
        c.put("isOpenLending", true);
        c.put("isDocGen2", true);
        c.put("isDefi", true);
        c.put("meridianLenderReferenceId", "string");
        c.put("meridianOrgReferenceId", "string");
        c.put("lenderPurposeType", "string");
        c.put("acumaticaId", "string");
        c.put("isGenericAprCalculation", true);
        c.put("isAcumaticaSpecialProcessing", true);
        c.put("autoSubmitLoanApplication", true);
        c.put("numericId", 0);
        c.put("isFlStampFee", true);
        c.put("isDealertrack", true);
        c.put("dealertrackId", 0);
        c.put("subRank", 0);
        c.put("isRestrictDr", true);
        c.put("generalInfo", b);
        given().
                header("Content-Type", "application/json").
                body(c.toString()).
                when().
                post("https://qa-api-v2.ilendingdirect.com/lender-service/lenders").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);

    }

}
