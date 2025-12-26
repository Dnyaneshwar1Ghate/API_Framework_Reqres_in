package test;

import payload.PostPayload;
import utils.TestUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import Base.BaseTest;
import endPoints.Routes;

public class PostAPITest extends BaseTest {

    @Test
    public void getPostTest() {

        given()
        .when()
            .get(Routes.getPostById)
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", equalTo(1))
            .log().all();
    }

    @Test
    public void createPostTest() {

        PostPayload payload = new PostPayload();
        payload.setUserId(10);
        payload.setTitle("API Automation");
        payload.setBody("Learning REST Assured BDD");

        given()
            .header("Content-Type", TestUtils.getContentType())
            .body(payload)
        .when()
            .post(Routes.createPost)
        .then()
            .statusCode(201)
            .body("title", equalTo("API Automation"))
            .body("body", equalTo("Learning REST Assured BDD"))
            .log().all();
    }
}
