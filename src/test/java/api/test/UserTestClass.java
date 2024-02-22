package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestClass {
	Faker f;
	User userpayload;
	@BeforeClass
	public void setupData() {
		f=new Faker();
		userpayload=new User();
		userpayload.setId(f.idNumber().hashCode());
		userpayload.setUsername(f.name().username());
		userpayload.setFirstname(f.name().firstName());
		userpayload.setLastname(f.name().lastName());
		userpayload.setEmail(f.internet().safeEmailAddress());
		userpayload.setPassword(f.internet().password(5, 10));
		userpayload.setPhone(f.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		
		Response res=userEndPoints.createUser(userpayload);
		System.out.println("Data created using post method:");
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void testGetUser() {
		Response res=userEndPoints.getUser(this.userpayload.getUsername());
		System.out.println("Data we got using getUser method:");
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		userpayload.setEmail(f.internet().safeEmailAddress());
		userpayload.setPassword(f.internet().password(5, 10));
		
		Response res=userEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		
		
		Response reqres= userEndPoints.getUser(this.userpayload.getUsername());
		//chai assertion
		reqres.then().log().body().statusCode(200);
		//restassured assertion
		System.out.println("udated data:");
		reqres.then().log().all();
		Assert.assertEquals(reqres.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response res= userEndPoints.deleteUser(this.userpayload.getUsername());
		res.then().log().body().statusCode(200);
	}
}























