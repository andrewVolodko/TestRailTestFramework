package tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTestHomework {

    @BeforeClass
    public void initRestClient() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "api";
    }

    @Test
    public void listUsersRequest() {
        String expectedResponse = "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        var response = given()
                .queryParam("page", 2)
                .get("users");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().getList("data").size(), 6);
    }

    @Test
    public void singeUserRequest() {
        String expectedResponse = "{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        var response = given().get("users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void singeUserNotFoundRequest() {
        String expectedResponse = "{}";

        var response = given().get("users/23");

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void listResourceRequest(){
        String expectedResponse = "{\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":1,\"name\":\"cerulean\",\"year\":2000,\"color\":\"#98B2D1\",\"pantone_value\":\"15-4020\"},{\"id\":2,\"name\":\"fuchsia rose\",\"year\":2001,\"color\":\"#C74375\",\"pantone_value\":\"17-2031\"},{\"id\":3,\"name\":\"true red\",\"year\":2002,\"color\":\"#BF1932\",\"pantone_value\":\"19-1664\"},{\"id\":4,\"name\":\"aqua sky\",\"year\":2003,\"color\":\"#7BC4C4\",\"pantone_value\":\"14-4811\"},{\"id\":5,\"name\":\"tigerlily\",\"year\":2004,\"color\":\"#E2583E\",\"pantone_value\":\"17-1456\"},{\"id\":6,\"name\":\"blue turquoise\",\"year\":2005,\"color\":\"#53B0AE\",\"pantone_value\":\"15-5217\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        var response = given().get("unknown");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void singleResourceRequest(){
        String expectedResponse = "{\"data\":{\"id\":2,\"name\":\"fuchsia rose\",\"year\":2001,\"color\":\"#C74375\",\"pantone_value\":\"17-2031\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        var response = given().get("unknown/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void singeResourceNotFoundRequest() {
        String expectedResponse = "{}";

        var response = given().get("unknown/23");

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void createRequest(){
        User user = new User("morpheus", "leader");
        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(user))
                .post("users");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getBody().jsonPath().getString("name"), user.name);
        Assert.assertEquals(response.getBody().jsonPath().getString("job"), user.job);
    }

    @Test
    public void updateRequest(){
        User user = new User("morpheus", "zion resident");
        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(user))
                .put("users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().getString("name"), user.name);
        Assert.assertEquals(response.getBody().jsonPath().getString("job"), user.job);
    }

    @Test
    public void patchRequest(){
        User user = new User("morpheus", "zion resident");
        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(user))
                .patch("users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().getString("name"), user.name);
        Assert.assertEquals(response.getBody().jsonPath().getString("job"), user.job);
    }

    @Test
    public void deleteRequest(){
        var response = given().delete("users/2");

        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void registerSuccessfulRequest(){
        String expectedResponse = "{\"id\":4,\"token\":\"QpwL5tke4Pnpja7X4\"}";

        var registrationObj = new Registration("eve.holt@reqres.in", "pistol");

        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(registrationObj))
                .post("register");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void registerUnsuccessfulRequest(){
        String expectedResponse = "{\"error\":\"Missing password\"}";

        var registrationUnsuccessfulObj = new RegisterUnsuccessful("sydney@fife");

        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(registrationUnsuccessfulObj))
                .post("register");

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void loginSuccessfulRequest(){
        String expectedResponse = "{\"token\":\"QpwL5tke4Pnpja7X4\"}";

        var loginObj = new Registration("eve.holt@reqres.in", "cityslicka");

        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(loginObj))
                .post("login");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void loginUnsuccessfulRequest(){
        String expectedResponse = "{\"error\":\"Missing password\"}";

        var loginObj = new RegisterUnsuccessful("peter@klaven");

        var response = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(loginObj))
                .post("login");

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }

    @Test
    public void delayResponseRequest(){
        String expectedResponse = "{\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\",\"avatar\":\"https://reqres.in/img/faces/1-image.jpg\"},{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},{\"id\":3,\"email\":\"emma.wong@reqres.in\",\"first_name\":\"Emma\",\"last_name\":\"Wong\",\"avatar\":\"https://reqres.in/img/faces/3-image.jpg\"},{\"id\":4,\"email\":\"eve.holt@reqres.in\",\"first_name\":\"Eve\",\"last_name\":\"Holt\",\"avatar\":\"https://reqres.in/img/faces/4-image.jpg\"},{\"id\":5,\"email\":\"charles.morris@reqres.in\",\"first_name\":\"Charles\",\"last_name\":\"Morris\",\"avatar\":\"https://reqres.in/img/faces/5-image.jpg\"},{\"id\":6,\"email\":\"tracey.ramos@reqres.in\",\"first_name\":\"Tracey\",\"last_name\":\"Ramos\",\"avatar\":\"https://reqres.in/img/faces/6-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        var response = given()
                .queryParam("delay", 3)
                .get("users");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.getBody().asString(), expectedResponse);
    }
}