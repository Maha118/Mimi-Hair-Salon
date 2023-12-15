package com.mimisalon.casestudy.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
/* this class helps in validating user input during
the registration process. It ensures that the email
follows the correct format, the password meets certain
complexity requirements, and the confirmation password
is not empty. These validations are crucial for maintaining
 data integrity and security in a web application.*/
@Getter
@Setter
public class RegisterUserFormBean {

    @Email(message = "Email must be a valid email address")
    private String email;

    @Length(min=8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one lowercase letter, one uppercase letter, and one digit")
    private String password;

    @NotEmpty(message = "Confirm Password cannot be empty")
    private String confirmPassword;
}
