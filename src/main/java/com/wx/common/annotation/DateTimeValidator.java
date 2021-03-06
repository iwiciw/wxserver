package com.wx.common.annotation;

import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateTimeValidator implements ConstraintValidator<DateTimeStr, String> {

    private DateTimeStr dateTimeStr;

    @Override
    public void initialize(DateTimeStr dateTimeStr) {
        this.dateTimeStr = dateTimeStr;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果 value 为空则不进行格式验证，为空验证可以使用 @NotBlank @NotNull @NotEmpty 等注解来进行控制，职责分离
        if (value == null) {
            return true;
        }
        String format = dateTimeStr.format();

        if (value.length() != format.length()) {
            return false;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        try {
            simpleDateFormat.parse(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static boolean isValid(String value, String format) {
        if (value == null) {
            return false;
        }

        if (value.length() != format.length()) {
            return false;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        try {
            simpleDateFormat.parse(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isValid("2022-7-08","yyyy-MM-dd"));
        System.out.println(isValid("2022-7-08","yyyy-MM"));
        System.out.println(isValid("2022","yyyy"));
        System.out.println(isValid("2022-07","yyyy-MM"));
    }
}
