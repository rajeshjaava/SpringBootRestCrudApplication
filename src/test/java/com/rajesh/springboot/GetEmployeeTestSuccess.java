package com.rajesh.springboot;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajesh.springboot.model.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestCurdAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetEmployeeTestSuccess {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetEmployeeWithInputRequestId() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employee/3"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\r\n" + 
				"\"id\": 3,\r\n" + 
				"\"name\": \"rajesh\",\r\n" + 
				"\"salary\": \"180000\",\r\n" + 
				"\"address\": \"Bglr\"\r\n" + 
				"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void createEmployeeTest() {
		Employee emp=new Employee();
		emp.setName("Ravi");
		emp.setAddress("Vizag");
		emp.setSalary("100000");
		HttpEntity<Employee> entity=new HttpEntity<Employee>(emp,headers);
		ResponseEntity<String> response=restTemplate.
				exchange(createURLWithPort("/employee"),
						HttpMethod.POST, entity, String.class);
		HttpStatus responseCode=response.getStatusCode();
		assertEquals(HttpStatus.CREATED,responseCode);
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}