package com.osintegrators.example;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dmistry
 * 
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAddressService {
	
	@Autowired
	AddressService addressService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAddress() {
		String expectedName = "John Doe";
		String expectedAddress = "345 West Main St\nDurham, NC";
		String expectedPhone = "+1.919.321.0119";
		String expectedEmail = "spam@osintegrators.com";
		Address address = createAddressObject(expectedName, expectedAddress,
				expectedPhone, expectedEmail);
		addressService.createAddress(address);
		Address result = addressService.getAddressById(1L);

		assertEquals(expectedName, address.getName());
		assertEquals(expectedAddress, address.getAddress());
		assertEquals(expectedPhone, address.getPhone());
		assertEquals(expectedEmail, address.getEmail());
	}

	private Address createAddressObject(String name, String address, String phone, String email) {
		Address address1 = new Address(name, address, phone, email);
		return address1;
	}
}