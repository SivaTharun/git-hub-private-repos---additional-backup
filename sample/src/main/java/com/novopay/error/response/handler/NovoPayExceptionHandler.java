package com.novopay.error.response.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.novopay.wallet.sample.dto.GlobalError;
import com.novopay.wallet.sample.dto.NovoPayException;

@RestControllerAdvice
public class NovoPayExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NovoPayException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public GlobalError handleNovoPayException(NovoPayException ne) {
    GlobalError globalError = new GlobalError();
    globalError.setMessage(ne.getMessage());
    globalError.setErrorReason(ne.getErrorReason());
    return globalError;
  }

}
