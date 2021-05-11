package tests;

import apiSteps.ApiSteps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ProjectModel;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void test(){
        var apiSteps = new ApiSteps("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        var response = apiSteps.addProject(ProjectModel.getDefault());

        var test = new Gson().fromJson(response.getBody().asString(), ProjectModel.class);

        System.out.println(response.prettyPrint());
    }
}
