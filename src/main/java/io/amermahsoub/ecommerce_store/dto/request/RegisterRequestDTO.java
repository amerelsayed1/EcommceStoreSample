package io.amermahsoub.ecommerce_store.dto.request;

import io.amermahsoub.ecommerce_store.entities.user.Role;
import io.amermahsoub.ecommerce_store.validation.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@PasswordMatch(message = "Password and confirm password must match")
public class RegisterRequestDTO {
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 50, message = "The length of password be between 8 and 50 characters.")
    private String password;
    @NotBlank(message = "Confirm Password is mandatory")
    private String confirmPassword;
    private Role role;
}
