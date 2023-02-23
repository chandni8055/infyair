package com.infosys.infyair.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErrorInfo> eventRegistrationExceptionHandler(InvalidUserException exception) {
        LOGGER.error(exception.getMessage(), exception);

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorInfo.setErrorMessage(exception.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(InfyAirException.class)
    public ResponseEntity<ErrorInfo> eventRegistrationExceptionHandler(InfyAirException exception) {
        LOGGER.error(exception.getMessage(), exception);

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorInfo.setErrorMessage(exception.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorInfo.setErrorMessage("General.EXCEPTION_MESSAGE");

        return new ResponseEntity<>(errorInfo,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}