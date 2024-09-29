package com.cg.hms.service;

import java.util.List;


import com.cg.hms.entity.Staff;

public interface StaffService {
	
	public String addStaff(Staff staff);

	public String updateStaff(String id, Staff staff);
	public Staff viewStaff(String id);
	public String deleteStaff(String id);
	
	public List<Staff> viewAllStaff();
}
