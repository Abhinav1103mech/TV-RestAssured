import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.util.*;

public class GetResponse {
    @Test
    public static void singleUser(){
        Response response = given().get("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(200)
                .extract().response();
        String responseBody = response.asString();
        System.out.println(responseBody);
        String id = response.getBody().jsonPath().get("data.id").toString();
        System.out.println(id);
        Assert.assertNotNull(id);
    }
    @Test
    public static void invalidUser(){
        Response response = given().get("https://reqres.in/api/users/23")
                        .then().assertThat().statusCode(404).extract().response();
        String responseBody = response.asString();
        System.out.println(responseBody);
    }
    @Test
    public static  void listOfUser(){
        Response response = given().get("https://reqres.in/api/users?page=2")
                .then().assertThat().statusCode(200)
                .extract().response();
        String id = response.getBody().jsonPath().get("data.id").toString();
        System.out.println(id);

    }
    @Test
    public static void getListResource(){
        Response response = given().get("https://reqres.in/api/unknown")
                .then().assertThat().statusCode(200)
                .extract().response();
        String id = response.getBody().jsonPath().get("data.id").toString();
        System.out.println(id);
    }


}
