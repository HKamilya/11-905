package ru.kpfu.itis.demo.blog.impl.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.demo.blog.api.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.findByEmail(s).isPresent();
    }
}
