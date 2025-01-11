package io.amermahsoub.ecommerce_store.validation;

import io.amermahsoub.ecommerce_store.dto.request.RegisterRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterRequestDTO> {
    @Override
    public boolean isValid(RegisterRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
            return false;
        }
        return dto.getPassword().equals(dto.getConfirmPassword());
    }
}
