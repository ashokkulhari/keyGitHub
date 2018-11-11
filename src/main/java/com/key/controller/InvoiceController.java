package com.key.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.key.model.Invoice;
import com.key.model.InvoiceDetail;
import com.key.model.ProductMaster;
import com.key.model.ProductMasterModel;
import com.key.model.User;
import com.key.service.CompanyService;
import com.key.service.CustomerService;
import com.key.service.InvoiceDetailService;
import com.key.service.InvoiceService;
import com.key.service.UserService;
import com.key.util.ApplicationConstants;
import com.key.util.CommonUtils;

@RestController
@CrossOrigin
public class InvoiceController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_INVOICE_DETAIL_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllInvoiceDetail(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_INVOICE_DETAIL_URL) ){
					List<InvoiceDetail> invoiceDetails =invoiceDetailService.getAllInvoiceDetail();
					System.out.println("invoiceDetails ==== "+invoiceDetails);
					response.put("output", invoiceDetails);
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
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_INVOICE_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllInvoice(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_INVOICE_URL) ){
					List<Invoice> invoices =invoiceService.getAllInvoice();
					System.out.println("invoices ==== "+invoices);
					response.put("output", invoices);
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
	
	@RequestMapping(value={ApplicationConstants.REQ_POST_INVOICE_SAVE_URL}, method = RequestMethod.POST)
	public ResponseEntity<?> saveInvoice(@RequestBody Invoice invoice,
			@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization, UriComponentsBuilder ucBuilder){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_POST_INVOICE_SAVE_URL) ){
					
//					Invoice invoice = null;//setProductMasterEntity(productMasterModel);
					
					invoice =invoiceService.saveInvoice(invoice);
					System.out.println("invoice ==== "+invoice);
					response.put("output", invoice);
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
