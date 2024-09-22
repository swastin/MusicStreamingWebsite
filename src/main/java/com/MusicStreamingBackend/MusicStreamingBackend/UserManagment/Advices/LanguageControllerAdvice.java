package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions.*;

@ControllerAdvice
@Slf4j
public class LanguageControllerAdvice {

    @ExceptionHandler(LanguageNameNotFound.class)
    public ResponseEntity<String> handleLanguageNotFoundException(LanguageNameNotFound exception) {
        log.error("Language not found: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LanguageNotSavedException.class)
    public ResponseEntity<String> handleLanguageNotSavedException(LanguageNotSavedException exception) {
        log.error("Language could not be saved: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LanguageNotUpdatedException.class)
    public ResponseEntity<String> handleLanguageNotUpdatedException(LanguageNotUpdatedException exception) {
        log.error("Language could not be updated: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LanguageNotDeletedException.class)
    public ResponseEntity<String> handleLanguageNotDeletedException(LanguageNotDeletedException exception) {
        log.error("Language could not be deleted: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception exception) {
        log.error("An unexpected error occurred: {}", exception.getMessage());
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
