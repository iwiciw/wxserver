package com.wx.utils;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;


public final class Validator {

    private Validator() {

    }


    private static javax.validation.Validator valid = Validation.buildDefaultValidatorFactory().getValidator();

    public static boolean check(Object object) {
        Set<ConstraintViolation<Object>> violations = valid.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
        return true;
    }

    public static boolean checkWithGroup(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = valid.validate(object, groups);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
        return true;
    }
}
