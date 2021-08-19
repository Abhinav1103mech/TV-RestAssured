import User.CreateLoginSuccesful;
import User.CreateUserRequestBody;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.response.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

public class DeleteResponse {
    @Test
    public void delete(){
        Response response = given().delete("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(204).extract().response();
    }
}
