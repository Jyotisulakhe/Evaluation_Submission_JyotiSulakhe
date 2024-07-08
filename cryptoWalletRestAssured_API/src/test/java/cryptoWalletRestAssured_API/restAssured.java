package cryptoWalletRestAssured_API;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class restAssured {
	
	String url="https://crypto-wallet-server.mock.beeceptor.com";
	@Test
	public void registerAUser() {
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("username", "user123");
		js.put("password", "securepassword");
		js.put("email", "user@example.com");

		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/register").then().log().all();
		
	}
	
	@Test
	public void loginTheUser() {
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("username", "user123");
		js.put("password", "securepassword");
		

		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/login").then().log().all();
		
	}
	@Test
	public void retriveBalance() {
		given().get("/api/v1/balance").then().log().all();

		
	}
	
	@Test
	public void listAllTransactions() {
		given().get("/api/v1/transactions").then().log().all();

		
	}
	
	@Test
	public void transfer() {
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", 5.0);
		js.put("currency", "ETH");

		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/transactions").then().log().all();
		
	}
	
	@Test
	public void calculateTransaction() {
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", 2.5);
		js.put("currency", "BTC");
		

		given().contentType("application/json").body(js.toJSONString()).when().post("/api/v1/transaction_fee").then().log().all();
		
	}

	@Test
	public void getAnObject() {
		given().get("/api/v1/exchange_rates").then().log().all();

		
	}
}
