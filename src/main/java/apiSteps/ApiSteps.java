package apiSteps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.PropertyReader;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ProjectModel;

import static io.restassured.RestAssured.given;


public class ApiSteps {

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public ApiSteps(String email, String password) {
        RestAssured.baseURI = new PropertyReader().getBaseUrl();
        RestAssured.basePath = "/api/v2";
        var basicAuthScheme = new PreemptiveBasicAuthScheme();
        basicAuthScheme.setUserName(email);
        basicAuthScheme.setPassword(password);
        RestAssured.authentication = basicAuthScheme;
    }

    @Step("Send add_project API request")
    public Response addProject(ProjectModel project){
        var response = given()
                .contentType(ContentType.JSON)
                .body(this.gson.toJson(project))
                .post("/add_project");

        if(response.statusCode() != 200)
            response.prettyPrint();

        return response;
    }
}
