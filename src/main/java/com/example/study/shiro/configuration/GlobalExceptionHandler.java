package com.example.study.shiro.configuration;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleException(UnauthenticatedException e) {
        LOGGER.debug("{} was thrown", e.getClass(), e);
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleException(AuthorizationException e) {
        LOGGER.debug("{} was thrown", e.getClass(), e);
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleUnknownAccountException(UnknownAccountException e) {
        LOGGER.debug("{} was thrown", e.getClass(), e);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleUnknownAuthenticationException(AuthenticationException e) {
        LOGGER.debug("{} was thrown", e.getClass(), e);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleIncorrectCredentialsException(IncorrectCredentialsException e) {
        LOGGER.debug("{} was thrown", e.getClass(), e);
    }


}
