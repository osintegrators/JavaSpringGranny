package com.osintegrators.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osintegrators.example.Address;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	public void createAddress(Address address) {
		addressRepository.save(address);
	}

	public List<Address> getAllAddresses() {
		return addressRepository.findAll();

	}

	public void deleteAddress(Address address) {
		addressRepository.delete(address);
	}

	public Address getAddressById(Long id) {
		return addressRepository.findOne(id);
	}

	public void updateAddress(Address address) {
		addressRepository.save(address);

	}

}