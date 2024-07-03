package com.games.Games.controllers.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

      private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
      public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundExeption){
          return new ResponseEntity<>("Element not found!", HttpStatus.NOT_FOUND);
      }

      @ExceptionHandler(Throwable.class)
      public ResponseEntity<String> HandleUnexpectedException(Throwable unexpectedException){
          var message = "Unexpected server error. Please, see the logs.";
          logger.error(message, unexpectedException);
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
}
