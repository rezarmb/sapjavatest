package test.com.h2rd.refactoring.unit;


import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.h2rd.refactoring.controller.UserController;
import com.h2rd.refactoring.model.User;
import com.h2rd.refactoring.persistence.UserDao;

import javax.ws.rs.core.Response;

public class UserResourceUnitTest {

	@Autowired
	UserController userController;
    
    @Autowired
    UserDao userDao;

    @Test
    public void getUsersTest() {

    	userController = new UserController();
        
        User user = new User();
        user.setName("fake user");
        user.setEmail("fake@user.com");
        userDao.saveUser(user);

        Response response = userController.get();
        Assert.assertEquals(200, response.getStatus());
    }
}
