package com.tsl.service;

import com.tsl.pojo.Login;

public interface LoginService {
    Login createLogin(String email, String password, String role);
    Login authenticate(String email, String password);
    boolean existsById(Long id);
    Login findById(Long id);  // Add this method
    
    
}
