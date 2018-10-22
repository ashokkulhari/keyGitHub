package com.key.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.key.model.ProductMaster;
import com.key.model.User;
import com.key.service.ProductMasterService;
import com.key.service.UserService;
import com.key.util.ApplicationConstants;
import com.key.util.CommonUtils;


@RestController
@CrossOrigin
public class ProductController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductMasterService productMasterService;
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_PRODUCT_BYID_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") int id,
			@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_PRODUCT_BYID_URL) ){
					ProductMaster product =productMasterService.getProductMasterById(id);;
					System.out.println("product ==== "+product);
					response.put("output", product);
					entity= new ResponseEntity<>(response, HttpStatus.OK);
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
}
