package com.osintegrators.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.debug("in home method");

		return "home";
	}
	

	@RequestMapping(value = "/get/{_id}", method = RequestMethod.GET)
	public @ResponseBody Address get(@PathVariable Long _id) {
	        logger.debug("in get method");
	       return addressService.getAddressById(_id);	        
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@RequestBody Address address) {
	        logger.debug("in create method");

		addressService.createAddress(address);

	}
	

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Address address) {
	        logger.debug("in create method");

		addressService.createAddress(address);

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody Address address) {
	        logger.debug("in delete method");
	                
	       addressService.deleteAddress(address);
	}
	
	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Address> list() {
	        logger.debug("in create method");

		return addressService.getAllAddresses();
	}

}
