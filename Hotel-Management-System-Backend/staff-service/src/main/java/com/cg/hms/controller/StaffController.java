package com.cg.hms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cg.hms.entity.Staff;
import com.cg.hms.exception.StaffNotFoundException;
import com.cg.hms.service.StaffService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    StaffService staffService;

    @PostMapping("/addstaff")
    public String addStaff(@RequestBody @Valid Staff staff) throws StaffNotFoundException {
        logger.info("Adding staff: " + staff.toString());
        return staffService.addStaff(staff);
    }

    @PutMapping("/updatestaff/{id}")
    public String updateStaff(@PathVariable String id, @RequestBody Staff staff) throws StaffNotFoundException {
        logger.info("Updating staff with ID: " + id);
        return staffService.updateStaff(id, staff);
    }

    @DeleteMapping("/deletestaff/{id}")
    public String deleteStaff(@PathVariable String id) throws StaffNotFoundException {
        logger.info("Deleting staff with ID: " + id);
        return staffService.deleteStaff(id);
    }

    @GetMapping("/viewallstaff")
    public List<Staff> viewAllStaff() throws StaffNotFoundException {
        logger.info("Viewing all staff");
        return staffService.viewAllStaff();
    }
}
