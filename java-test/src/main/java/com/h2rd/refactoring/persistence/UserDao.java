package com.h2rd.refactoring.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.h2rd.refactoring.model.User;

@Component
public class UserDao {

    public ArrayList<User> users;
        
  //----------------------------------------------
    public ArrayList<User> getUsers() 
    {
        try {
        	
        	users = new ArrayList<User>();
        	
        	List<String> roles = Arrays.asList("foo", "bar", "baz");
        	
        	User u1 = new User();
        	u1.setName("Test1");
        	u1.setEmail("test1@gmail.com");
        	u1.setRoles(roles);
        	
        	User u2 = new User();
        	u2.setName("Test2");
        	u2.setEmail("test2@gmail.com");
        	u2.setRoles(roles);
        	
        	users.add(u1);
        	users.add(u2);
        	
            return users;
            
        } catch (Throwable e) {
            System.out.println("error");
            return null;
        }
    }
    
    
  //----------------------------------------------
    
    public User findUser(String name) {
        try {
            for (User user : users) {
                if (user.getName() == name) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
    
  //----------------------------------------------
    
    public void saveUser(User user) {
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(user);
    }
    
  //----------------------------------------------
    
    public void updateUser(User userToUpdate) {
        try {
            for (User user : users) {
                if (user.getName() == userToUpdate.getName()) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    
  //----------------------------------------------
    
    public void deleteUser(String userToDelete) {
        try {
            for (User user : users) {
                if (user.getName() == userToDelete) {
                    users.remove(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  //----------------------------------------------
    
}
