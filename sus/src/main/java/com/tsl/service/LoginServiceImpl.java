package com.tsl.service;

import com.tsl.pojo.Login;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login createLogin(String email, String password, String role) {
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        login.setRole(role);
        return loginRepository.save(login);
    }

    @Override
    public Login authenticate(String email, String password) {
        Login login = loginRepository.findByEmail(email);
        if (login != null && login.getPassword().equals(password)) {
            return login;
        }
        return null;
    }
    
    @Override
    public boolean existsById(Long id) {
        return loginRepository.existsById(id); // Implement the check using the repository
    }
    
    
    @Override
    public Login findById(Long id) {
        return loginRepository.findById(id).orElse(null);  // Implement the method using repository
    }
}
