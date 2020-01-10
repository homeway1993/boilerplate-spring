package boilerplate.spring.web.controller;

import boilerplate.spring.web.exception.NotFoundException;
import boilerplate.spring.web.pojo.ErrorResponse;
import boilerplate.spring.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handle specific exception thrown by all Spring controller.
 */
@RestControllerAdvice
public class GlobalExceptionController {

    @Autowired
    private MessageService messageService;

    /**
     * Handle exception thrown when validation on an argument annotated with {@code @Valid} fails.
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(BindException e) {
        List<ErrorResponse.ErrorMsg> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> {
                    ErrorResponse.ErrorFieldMsg errorFieldMsg = new ErrorResponse.ErrorFieldMsg();
                    errorFieldMsg.setMessage(this.getMessage(fieldError.getDefaultMessage()));
                    errorFieldMsg.setErrorCode(fieldError.getDefaultMessage());
                    errorFieldMsg.setEntity(fieldError.getObjectName());
                    errorFieldMsg.setProperty(fieldError.getField());
                    errorFieldMsg.setInvalidValue(fieldError.getRejectedValue());
                    return errorFieldMsg;
                })
                .collect(Collectors.toList());

        ErrorResponse validationResponse = new ErrorResponse();
        validationResponse.setErrors(errors);
        return validationResponse;
    }

    /**
     * Handle exception thrown when validation on an argument annotated with
     * {@code @RequestBody} and {@code @Valid} fails.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorResponse.ErrorMsg> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> {
                    ErrorResponse.ErrorFieldMsg errorFieldMsg = new ErrorResponse.ErrorFieldMsg();
                    errorFieldMsg.setMessage(this.getMessage(fieldError.getDefaultMessage()));
                    errorFieldMsg.setErrorCode(fieldError.getDefaultMessage());
                    errorFieldMsg.setEntity(fieldError.getObjectName());
                    errorFieldMsg.setProperty(fieldError.getField());
                    errorFieldMsg.setInvalidValue(fieldError.getRejectedValue());
                    return errorFieldMsg;
                })
                .collect(Collectors.toList());

        ErrorResponse validationResponse = new ErrorResponse();
        validationResponse.setErrors(errors);
        return validationResponse;
    }

    /**
     * Return 404 NotFound and specific error message.
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        ErrorResponse.ErrorMsg errors = new ErrorResponse.ErrorMsg();
        errors.setMessage("No results");

        ErrorResponse validationResponse = new ErrorResponse();
        validationResponse.setErrors(Collections.singletonList(errors));
        return validationResponse;
    }

    private String getMessage(String errorCode) {
        try {
            return messageService.getMessage(errorCode);
        } catch (NoSuchMessageException e) {
            return errorCode;
        }
    }
}
