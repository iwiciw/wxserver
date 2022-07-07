package com.wx.config.aspect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.common.BaseResponse;
import com.wx.common.exception.BizException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public BaseResponse<Serializable> handleBizException(BizException ex) {
        return BaseResponse.error(ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public BaseResponse<Serializable> handleThrowable(Throwable t) {
        log.error("Throwable occur.", t);
        return BaseResponse.error("system error");
    }

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public BaseResponse<Serializable> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> errorMes = new ArrayList<>();
        constraintViolations.forEach(e -> errorMes.add(e.getMessage()));
        String exceptionMes = StringUtils.join(errorMes, "|");
        log.info(exceptionMes, ex);
        return BaseResponse.error(exceptionMes);
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResponse<Serializable> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        List<String> errorMes = new ArrayList<>();
        errors.forEach(e -> errorMes.add(e.getDefaultMessage()));
        String exceptionMes = StringUtils.join(errorMes, "|");
        log.info(exceptionMes, ex);
        return BaseResponse.error(exceptionMes);
    }

    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public BaseResponse<Serializable> illegalArgumentExceptionHandler(Exception ex) {
        log.info(ex.getMessage(), ex);
        return BaseResponse.error(ex.getMessage());
    }
}
