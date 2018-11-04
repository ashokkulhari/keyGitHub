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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.key.model.Category;
import com.key.model.Color;
import com.key.model.Customer;
import com.key.model.GroupCode;
import com.key.model.Invoice;
import com.key.model.InvoiceDetail;
import com.key.model.Location;
import com.key.model.Manufacture;
import com.key.model.Model;
import com.key.model.ProductMaster;
import com.key.model.SubCategory;
import com.key.model.Unit;
import com.key.model.User;
import com.key.model.Vendor;
import com.key.service.CategoryService;
import com.key.service.ColorService;
import com.key.service.CustomerService;
import com.key.service.GroupCodeService;
import com.key.service.InvoiceDetailService;
import com.key.service.InvoiceService;
import com.key.service.LocationService;
import com.key.service.ManufactureService;
import com.key.service.ModelService;
import com.key.service.ProductMasterService;
import com.key.service.SubCategoryService;
import com.key.service.UnitService;
import com.key.service.UserService;
import com.key.service.VendorService;
import com.key.util.ApplicationConstants;
import com.key.util.CommonUtils;


@RestController
@CrossOrigin
public class ProductController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private GroupCodeService groupCodeService;
	
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ManufactureService manufactureService;
	
	@Autowired
	private ModelService modelService;
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private UnitService unitService;
	@Autowired
	private VendorService vendorService;
	
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
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_CATEGORY_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllCategory(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_CATEGORY_URL) ){
					List<Category> categories =categoryService.getAllCategory();
					System.out.println("categories ==== "+categories);
					response.put("output", categories);
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
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_COLOR_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllColor(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_COLOR_URL) ){
					List<Color> colors =colorService.getAllColor();
					System.out.println("colors ==== "+colors);
					response.put("output", colors);
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
	
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_CUSTOMER_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllCustomer(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_CUSTOMER_URL) ){
					List<Customer> customers =customerService.getAllCustomer();
					System.out.println("customers ==== "+customers);
					response.put("output", customers);
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
	
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_GROUP_CODE_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllGroupCode(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_GROUP_CODE_URL) ){
					List<GroupCode> groupCodes =groupCodeService.getAllGroupCode();
					System.out.println("groupCodes ==== "+groupCodes);
					response.put("output", groupCodes);
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
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_LOCATION_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllLocation(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_LOCATION_URL) ){
					List<Location> locations =locationService.getAllLocation();
					System.out.println("locations ==== "+locations);
					response.put("output", locations);
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
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_MANUFACTURE_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllManufacture(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_MANUFACTURE_URL) ){
					List<Manufacture> manufactures =manufactureService.getAllManufacture();
					System.out.println("manufactures ==== "+manufactures);
					response.put("output", manufactures);
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
	
	@RequestMapping(value={ApplicationConstants.REQ_GET_MODEL_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllModel(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_MODEL_URL) ){
					List<Model> models =modelService.getAllModel();
					System.out.println("models ==== "+models);
					response.put("output", models);
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
	@RequestMapping(value={ApplicationConstants.REQ_GET_SUBCATEGORY_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllSubCategory(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_SUBCATEGORY_URL) ){
					List<SubCategory> subCategories =subCategoryService.getAllSubCategory();
					System.out.println("subCategories ==== "+subCategories);
					response.put("output", subCategories);
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
	@RequestMapping(value={ApplicationConstants.REQ_GET_UNIT_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllUnit(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_UNIT_URL) ){
					List<Unit> units =unitService.getAllUnit();
					System.out.println("units ==== "+units);
					response.put("output", units);
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
	@RequestMapping(value={ApplicationConstants.REQ_GET_VENDOR_URL}, method = RequestMethod.GET)
	public ResponseEntity<?> getAllVendor(@RequestHeader(value="Authorization", defaultValue="Unauthorised") String authorization){
		
		
		Map<String, Object> response = new ManagedMap<>();
		ResponseEntity<Map<String, Object>> entity=null;
		
			User accountUser = userService.findUserByEmail(userService.extractUsername(authorization));
			if(accountUser!=null){
				if(CommonUtils.validateUserPermission(accountUser,ApplicationConstants.REQ_GET_VENDOR_URL) ){
					List<Vendor> Vendors =vendorService.getAllVendor();
					System.out.println("Vendors ==== "+Vendors);
					response.put("output", Vendors);
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
