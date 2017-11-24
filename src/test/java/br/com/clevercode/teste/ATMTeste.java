package br.com.clevercode.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ATMTeste   {
	
	@Test
	public void addUser() {
		Map<String, String>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("name", "Primeiro");
		jsonAsMap.put("saldo", "100");
		given().
		contentType("application/json;charset=UTF-8").
		        body(jsonAsMap).
        expect().when().post("/SpringBootCRUDApp/api/user/").then().statusCode(201);
	}
	
	
	

	
	
	
	
}
	 