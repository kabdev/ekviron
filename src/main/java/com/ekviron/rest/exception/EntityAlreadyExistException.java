package com.ekviron.rest.exception;

import org.springframework.util.StringUtils;

public class EntityAlreadyExistException extends RuntimeException {

    public EntityAlreadyExistException(Class<?> clazz) {
        super(EntityAlreadyExistException.generateMessage(clazz.getSimpleName()));
    }

    @Override
    // don't feel stack trace for business exception
    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    private static String generateMessage(String entity) {
        return StringUtils.capitalize(entity) + " already exist with same fields";
    }

}