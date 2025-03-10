package com.sau.userAuthentication.feignclient;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sau.userAuthentication.models.Staff;


@FeignClient(name = "StaffService",url = "http://localhost:9381/staff")
public interface StaffClient {
	
	@PostMapping("/addstaff")
    public String addStaff(@RequestBody @Valid Staff staff);
	
	@PutMapping("/updatestaff/{id}")
    public String updateStaff(@PathVariable String id, @RequestBody Staff staff);
	
	 @DeleteMapping("/deletestaff/{id}")
	    public String deleteStaff(@PathVariable String id) ;
	 
	 @GetMapping("/viewallstaff")
	    public List<Staff> viewAllStaff();

}
