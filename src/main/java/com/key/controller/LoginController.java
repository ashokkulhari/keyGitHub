package com.key.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.key.model.User;
import com.key.service.SecurityServices;
import com.key.service.UserService;
import com.key.util.ApplicationConstants;
import com.key.util.CommonUtils;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	@Autowired
	SecurityServices securityServices;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//Done
	@RequestMapping(value={"/register/"}, method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody User user, UriComponentsBuilder ucBuilder){
		LOGGER.info("Creating new account : " + user.getName());
		Map<String, Object> response = new ManagedMap<>();

        if(userService.findUserByEmail(user.getEmail()) != null) {
			response.put("msg", "Account with username " + user.getEmail() + " already exists.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
        userService.saveUser(user);

		response.put("msg", "User created.");
		response.put("userid", user.getUserId());
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<>(response,headers, HttpStatus.CREATED);
	}

	//Done
	//As we are using Basic auth, login method just verifies is this login:pass valid
	@RequestMapping(value={"/login/"}, method = RequestMethod.POST)
	
	public ResponseEntity<?> login(@RequestBody User user, UriComponentsBuilder ucBuilder){
		LOGGER.info("...................User login : " + user.getEmail());
		Map<String, String> response = new ManagedMap<>();

		User account = userService.findUserByEmail(user.getEmail());
		if(account == null) {
			response.put("msg", "User with username " + user.getEmail() + " not found.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else if (account.getActive() == UserService.NOT_ACTIVATED_USER) {
			response.put("msg", "User with username " + user.getEmail() + " not activated. \nPlease visit Your email.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		if(!bCryptPasswordEncoder.matches(user.getPassword(), account.getPassword())) {
			response.put("msg", "Password wrong.");
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}

		response.put("msg", "Login successful.");
		response.put("userfullname", account.getName());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//Done
	@RequestMapping(value={ApplicationConstants.REQ_CHANGE_PASS_URL}, method = RequestMethod.PUT)
	public ResponseEntity<?> changePass(@RequestBody User user,
										@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization,
										UriComponentsBuilder ucBuilder){
		LOGGER.info("User change pass : " + user.getName() +"   "+ SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
		if(userService.extractUsername(authorization).equals(user.getEmail()) ){
			User accountUser = userService.findUserByEmail(user.getEmail());
			if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_CHANGE_PASS_URL) ){
				if(userService.updateUser(user) != null){
					response.put("msg", "Username " + user.getEmail() + " password updated.");
					entity= new ResponseEntity<>(response, HttpStatus.CREATED);
				}else{
					response.put("msg", "User not found.");
					entity=new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
				}
			}else{
				response.put("msg", "User does not have permission..");
				entity=new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
			}
				
		}else{
			response.put("msg", "User not found.");
			entity=new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		return entity;
	}

	

	//Done
	@RequestMapping(value={"/activateuser/"}, method = RequestMethod.GET)
	public ResponseEntity<?> activateUser(@RequestParam("username") String username,
										  @RequestParam("keyword") String keyword,
										  UriComponentsBuilder ucBuilder){
		LOGGER.info("User activating: username : " + username + "; keyword : " + keyword);
		User user = new User();
		user.setKeyword(keyword);
		user.setEmail(username);
		user = userService.activateUser(user);
		Map<String, String> response = new ManagedMap<>();

		if (user == null) {
			response.put("msg","Username " + username + " not exists.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		if (user.getActive() == UserService.NOT_ACTIVATED_USER) {
			response.put("msg","Username " + username + " was not activated. Probably there is a problem with confirmation link");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		response.put("msg","Username " + username + " activated.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//Done
	@RequestMapping(value={"/resetpass/"}, method = RequestMethod.PUT)
	public ResponseEntity<?> resetpass(@RequestBody User user, UriComponentsBuilder ucBuilder){

		LOGGER.info("User change forgotten pass : " + user.getEmail());
		Map<String, String> response = new ManagedMap<>();

		if (userService.resetPass(user)==null) {
			response.put("msg","Username " + user.getEmail() + " not found.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		response.put("msg","Username " + user.getEmail() + " password updated. Check Your email.");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	//Done
	//Set this user as inactive in database
	//Create cron job in database for user deletion
	@RequestMapping(value={"/deleteuser/"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUser(@RequestParam("username") String username, UriComponentsBuilder ucBuilder){
		LOGGER.info("User " + username + " deleting.");
		User user = userService.deleteUser(username);
		Map<String, String> response = new ManagedMap<>();
		if(user == null) {
			response.put("msg","Username " + user.getEmail() + " not found.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		if(user.getActive() == UserService.ACTIVATED_USER) {
			response.put("msg","Username " + user.getEmail() + " deletion error.");
			return new ResponseEntity<>("msg", HttpStatus.BAD_REQUEST);
		}

		response.put("msg","Username " + user.getEmail() + " deleted.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public String hello(@RequestParam(value = "input", required=false) String input){
		
		if(input!=null && !"".equals(input.trim())){
			return input;
		}else{
			return "Welcome to KeyServer";
		}
		
	}
	
}
