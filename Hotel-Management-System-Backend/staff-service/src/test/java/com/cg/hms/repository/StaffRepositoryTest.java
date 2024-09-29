package com.cg.hms.repository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;


import com.cg.hms.entity.Staff;
import com.cg.hms.repository.StaffRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class StaffRepositoryTest {
	@Mock
    private StaffRepository staffRepository;

	@Test
    public void testFindAll() {
        // Mock data
        Staff staff1 = new Staff("124","rISHITHA","KODURU","50000","ry@example.com","21");
        Staff staff2 = new Staff("12","ry","KODURU","50000","ry@example.com","21");
        List<Staff> trains = new ArrayList<>();
        trains.add(staff1);
        trains.add(staff2);

        when(staffRepository.findAll()).thenReturn(trains);

        List<Staff> result = staffRepository.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindStaffById() {
        Staff staff = new Staff("124","rISHITHA","KODURU","50000","ry@example.com","21");
        when(staffRepository.findById("124")).thenReturn(Optional.of(staff));

        Optional<Staff> result = staffRepository.findById("124");

        assertEquals(true, result.isPresent());
        assertEquals("KODURU", result.get().getAddress());
    }


}
