package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.excpetion;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizesResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

        ExcpetionResponse excpetionResponse =  new ExcpetionResponse(new Date(),ex.getMessage()
                ,request.getDescription(false));

        return    new ResponseEntity(excpetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {

        ExcpetionResponse excpetionResponse =  new ExcpetionResponse(new Date(),ex.getMessage()
                ,request.getDescription(false));

        return    new ResponseEntity(excpetionResponse, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        ExcpetionResponse excpetionResponse =  new ExcpetionResponse(new Date(),"Lenght Validation Failed"
                ,ex.getBindingResult().toString());

        return new ResponseEntity(excpetionResponse, HttpStatus.BAD_REQUEST);
    }

}
