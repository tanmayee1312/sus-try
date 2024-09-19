package com.tsl.controller;

import com.tsl.pojo.Login;
import com.tsl.service.LoginService;
import com.tsl.dto.LoginDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginDto loginDto) {
        loginService.createLogin(loginDto.getEmail(), loginDto.getPassword(), loginDto.getRole());
        return ResponseEntity.ok("User/ Admin registered successfully");
    }

    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto loginDto) {
        Login login = loginService.authenticate(loginDto.getEmail(), loginDto.getPassword());
        if (login != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", login.getId());
            response.put("role", login.getRole());

            if ("ROLE_USER".equals(login.getRole())) {
                response.put("message", "Welcome User");
            } else if ("ROLE_ADMIN".equals(login.getRole())) {
                response.put("message", "Welcome Admin");
            } else {
                return ResponseEntity.status(403).body(Map.of("message", "Not a valid user"));
            }
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
//        Login login = loginService.authenticate(loginDto.getEmail(), loginDto.getPassword());
//        if (login != null) {
//            String role = login.getRole();
//            if ("ROLE_USER".equals(role)) {
//                return ResponseEntity.ok("Welcome User");
//            } else if ("ROLE_ADMIN".equals(role)) {
//                return ResponseEntity.ok("Welcome Admin");
//            } else {
//                return ResponseEntity.status(403).body("Not a valid user");
//            }
//        }
//        return ResponseEntity.status(401).body("Invalid credentials");
//    }

}
