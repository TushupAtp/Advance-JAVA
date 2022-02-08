package com.cdac.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.DeletionStatus;
import com.cdac.dto.LoginDetails;
import com.cdac.dto.LoginStatus;
import com.cdac.dto.PicUploadStatus;
import com.cdac.dto.ProfilePicDetails;
import com.cdac.dto.RegistrationStatus;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//@PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
	@PostMapping("/register")
	public RegistrationStatus register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setMessage("Registration successful!");
			status.setRegisteredCustomerId(id); //pending
			return status;
		}
		catch (CustomerServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}	
	}
	
	@PostMapping("/upload-profile-pic")
	public PicUploadStatus uploadPic(ProfilePicDetails profilePicDetails) {
		//System.out.println(profilePicDetails.getCustomerId());
		//System.out.println(profilePicDetails.getProfilePic().getOriginalFilename());

		//store the image in some folder
		String uploadedPicName = profilePicDetails.getProfilePic().getOriginalFilename();
		String fileName = profilePicDetails.getCustomerId() + "-" + uploadedPicName;
		
		try {
			FileCopyUtils.copy(profilePicDetails.getProfilePic().getInputStream(), new FileOutputStream("d:/uploads/" + fileName));
		} catch (IOException e) {
			//hoping there won't be any error
		}
		
		//update the information in the db
		Customer customer = customerService.fetch(profilePicDetails.getCustomerId());
		customer.setProfilePic(fileName);
		customerService.update(customer);
		
		PicUploadStatus status = new PicUploadStatus();
		status.setStatus(true);
		status.setMessage("Pic uploaded!");
		return status;
	}
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody LoginDetails loginDetails) {
		try {
			Customer customer = customerService.login(loginDetails);
			LoginStatus status = new LoginStatus();
			status.setStatus(true);
			status.setMessage("Login successful!");
			//status.setCustomer(customer);
			status.setCustomerId(customer.getId());
			status.setCustomerName(customer.getName());
			return status;
		}
		catch(CustomerServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	/*@PostMapping("/login")
	public Customer login(@RequestBody LoginDetails loginDetails) {
		try {
			Customer customer = customerService.login(loginDetails);
			return customer;
		}
		catch(CustomerServiceException e) {
			//what to return now
		}
	}*/

	@GetMapping("/fetch-customer")
	public Customer fetch(@RequestParam("customerId") int id) {
		Customer customer = customerService.fetch(id);
		return customer;
	}
	
	@GetMapping("/fetch-all")
	public List<Customer> fetchAll() {
		List<Customer> list = customerService.fetchAll();
		return list;
	}

	@GetMapping("/delete-customer")
	public DeletionStatus delete(@RequestParam("customerId") int id) {
		//customerService.removePermanently(id);
		customerService.remove(id);
		
		DeletionStatus status = new DeletionStatus();
		status.setStatus(true);
		return status;
	}
}
