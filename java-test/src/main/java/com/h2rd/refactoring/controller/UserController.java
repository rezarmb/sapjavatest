package com.h2rd.refactoring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.h2rd.refactoring.model.User;
import com.h2rd.refactoring.persistence.UserDao;

@Controller
@RequestMapping("/rest")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	//----------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public synchronized ArrayList<User> get()
	{
		return userDao.getUsers();	
	}
	
	//----------------------------------------------
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	@ResponseBody
	public synchronized User get(@PathVariable("name") String user) 
	{
		User usr = userDao.findUser(user);
		
		if(usr == null) 
		{
			throw new NotFoundException();
		}
		
		return usr;
	}
	
	//----------------------------------------------
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public synchronized void post(@RequestBody User user) 
	{
		userDao.saveUser(user);	
	}
	
	//----------------------------------------------
	
	@RequestMapping(value="/{name}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public synchronized void put(@PathVariable("name") String name, @RequestBody User user) 
	{
		userDao.updateUser(user);
			
	}
	
	//----------------------------------------------
	
	@RequestMapping(value="/{name}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public synchronized void delete(@PathVariable("name") String user)
	{
		userDao.deleteUser(user);
			
	}
	
	//----------------------------------------------
	
	@RequestMapping(value="/{name}",method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "no user to delete")
	public void handleNotFound(NotFoundException exp)
	{
			
	}
	
	class NotFoundException extends RuntimeException
	{
		
	}
}
