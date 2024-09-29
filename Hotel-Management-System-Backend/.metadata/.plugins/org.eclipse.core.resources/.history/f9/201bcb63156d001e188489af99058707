package com.cg.hms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entity.Staff;
import com.cg.hms.exception.StaffNotFoundException;
import com.cg.hms.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

    private static final Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

    @Autowired
    StaffRepository staffRepository;

    @Override
    public String addStaff(Staff staff) throws StaffNotFoundException {
        if (staff.getStaffId().isEmpty()) {
            logger.error("Staff not found during addition");
            throw new StaffNotFoundException("Staff not found");
        } else {
            Staff s = staffRepository.save(staff);
            logger.info("Staff added successfully: " + s.toString());
            return "Success";
        }
    	
    }

    @Override
    public String updateStaff(String id, Staff staff) throws StaffNotFoundException {
        Optional<Staff> newId = staffRepository.findById(id);
        if (newId.isPresent()) {
            Staff old = newId.get();
            old.setStaffName(staff.getStaffName());
            old.setAddress(staff.getAddress());
            old.setSalary(staff.getSalary());
            staffRepository.save(old);
            logger.info("Staff updated successfully: " + old.toString());
            return "Updated Successfully";
        } else {
            logger.error("Staff not found during update");
            throw new StaffNotFoundException("Staff not found");
        }
    }

    @Override
    public String deleteStaff(String id) throws StaffNotFoundException {
        java.util.Optional<Staff> custContainer = staffRepository.findById(id);
        if (custContainer.isPresent()) {
            Staff cust = custContainer.get();
            staffRepository.delete(cust);
            logger.info("Staff deleted successfully: " + cust.toString());
            return "Deleted Successfully";
        } else {
            logger.error("Staff not found during deletion");
            throw new StaffNotFoundException("Staff not found");
        }
    }

    @Override
    public List<Staff> viewAllStaff() throws StaffNotFoundException {
        List<Staff> fi = staffRepository.findAll();
        if (fi.isEmpty()) {
            logger.error("No staff found during view all staff");
            throw new StaffNotFoundException("No staff found");
        }
        logger.info("Viewing all staff");
        return fi;
    }

    @Override
    public Staff viewStaff(String id) throws StaffNotFoundException {
        if (id == null) {
            logger.error("ID not found during staff view");
            throw new StaffNotFoundException("ID not found");
        }
        Staff staff = staffRepository.findById(id).get();
        logger.info("Viewing staff by ID: " + staff.toString());
        return staff;
    }
}
