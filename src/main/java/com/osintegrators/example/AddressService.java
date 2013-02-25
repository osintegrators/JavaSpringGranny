package com.osintegrators.example;

import java.util.List;

import com.osintegrators.example.Address;

public interface AddressService {

	void createAddress(Address add);

	void deleteAddress(Address add);

	List<Address> getAllAddresses();

	Address getAddressById(Long id);

	void updateAddress(Address address);

}
