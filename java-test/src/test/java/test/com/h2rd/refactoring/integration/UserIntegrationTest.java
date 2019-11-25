package test.com.h2rd.refactoring.integration;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h2rd.refactoring.controller.UserController;
import com.h2rd.refactoring.model.User;

public class UserIntegrationTest {
	
	@Autowired
	UserController userController;
	
	@Test
	@ResponseBody
	public void createUserTest() {
		
		User user = new User();
		user.setName("integration");
		user.setEmail("initial@integration.com");
		user.setRoles(new ArrayList<String>());
        
        userController.post(user);
        
        Assert.assertEquals(200, response.getStatus());
	}

	@Test
	@ResponseBody
	public void updateUserTest() {
				
		createUserTest();
        
        User updated = new User();
        updated.setName("integration");
        updated.setEmail("updated@integration.com");
        updated.setRoles(new ArrayList<String>());
        
        userController.put(updated.getName(), updated);
        Assert.assertEquals(200, response.getStatus());
	}
}
