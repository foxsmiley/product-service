package com.smiley.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
@ServiceConnection
	static MongoDBContainer mongoDBContainer =new MongoDBContainer("mongo:7.0.5");
	@LocalServerPort
	private Integer port;
@BeforeEach
	void setup(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;
	}
	static {
	mongoDBContainer.start();
	}
@Test
	void shouldCreateProduct() {
	String requestBody = """
			 {
			        "name": "HUAWEI P30",
			        "description": "HUAWEI P30 8gb ram",
			        "price": 100
			    }
			""";

	RestAssured.given()
			.contentType("application/json")
			.body(requestBody)
			.when()
			.post("api/product")
			.then()
			.statusCode(201)
			.body("id", Matchers.notNullValue())
			.body("name",Matchers.equalTo("HUAWEI P30"))
			.body("description",Matchers.equalTo("HUAWEI P30 8gb ram"))
			.body("price",Matchers.equalTo(100));
	}

}
