package com.tsl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",
            message = "Password must have one digit, one lower case alphabet, one upper case alphabet, one special character for eg(@#$%^&-+=()) and 8 to 20 characters with no white spaces")
    private String password;

    private String role; // Either "ROLE_USER" or "ROLE_ADMIN"
}
