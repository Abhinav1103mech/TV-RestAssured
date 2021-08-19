import User.CreateLoginSuccesful;
import User.CreateUserRequestBody;
import User.PatchUserResponse;
import User.UpdateUserRequestBody;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.response.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
public class PatchResponse {
    @Test
    public void path(){
        PatchUserResponse requestBody =
                PatchUserResponse.builder().name("morpheus").job("zion resident").build();
        Response response = given().contentType(ContentType.JSON)
                .body(requestBody)
                .put("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(200).extract().response();
        String job = response.getBody().jsonPath().get("job").toString();
        System.out.println(job);
        Assert.assertEquals(job,requestBody.getJob());
    }
}
