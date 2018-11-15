package com.example.test;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JacksonTest {
	
//	@Test
	public void JsonToStringWithJackson() {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		System.out.println(json);
		try {
			JsonNode jsonNode = objectMapper.readTree(json);
			String color = jsonNode.get("color").asText();
			System.out.println("color = "+ color);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		String json2 = "{\"name\": {\"first\": \"Tatu\",\"last\": \"Saloranta\"},\"title\": \"Jackson founder\",\"company\": \"FasterXML\"}";
		System.out.println(json2);
		try {
			JsonNode jsonNode2 = objectMapper2.readTree(json2);
			String title = jsonNode2.get("title").asText();
			System.out.println(title);
			String name = jsonNode2.get("name").asText();
			System.out.println(name);
			String first = jsonNode2.path("name").path("first").asText();
			System.out.println("first = " + first);
			String last = jsonNode2.path("name").get("last").asText();
			System.out.println("last = " + last);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void JsontoStringWithGson(){
		String json = "{\"name\": {\"first\": \"Tatu\",\"last\": \"Saloranta\"},\"title\": \"Jackson founder\",\"company\": \"FasterXML\"}";
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(json);
		String name = element.getAsJsonObject().get("name").getAsJsonObject().get("first").getAsString();
		System.out.println("name = "+name);
		String company = element.getAsJsonObject().get("company").getAsString();
		System.out.println("company = "+company);
//		int age = element.getAsJsonObject().get("age").getAsInt();
//		System.out.println("age = "+age);		
	}

}
