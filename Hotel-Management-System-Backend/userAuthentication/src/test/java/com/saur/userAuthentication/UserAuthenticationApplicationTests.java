package com.saur.userAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sau.userAuthentication.models.ERole;
import com.sau.userAuthentication.models.Role;
import com.sau.userAuthentication.models.User;
import com.sau.userAuthentication.payload.request.LoginRequest;
import com.sau.userAuthentication.repository.RoleRepository;
import com.sau.userAuthentication.repository.UserRepository;

@SpringBootTest

class UserAuthenticationApplicationTests {
	
	@Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

	@Test
	void contextLoads() {
	}

	@Test
    public void testAuthenticateUser() {
        // Create a test user
        Role userRole = new Role(ERole.ROLE_RECEPTIONIST);
        roleRepository.save(userRole);
        User user = new User("aaaaaa", "aaaaaa@example.com", "aaaaaa");
        user.setRoles(Set.of(userRole));
        userRepository.save(user);

        // Create a login request
        LoginRequest loginRequest = new LoginRequest("testuser", "password");

        // Send a POST request to /auth/signin
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/auth/signin", loginRequest, String.class);

        // Verify the response status code
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verify that the response contains a JWT token
        String response = responseEntity.getBody();
        assertNotNull(response);
        assertTrue(response.contains("accessToken"));
    }
}
