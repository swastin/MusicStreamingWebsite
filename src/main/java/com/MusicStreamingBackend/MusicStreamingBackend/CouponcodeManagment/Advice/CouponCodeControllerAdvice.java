package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Advice;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeDeletionException;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeSaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CouponCodeControllerAdvice {

    @ExceptionHandler(CouponCodeNotFound.class)
    public ResponseEntity<String> handleCouponCodeNotFound(CouponCodeNotFound exception){
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(CouponCodeSaveException.class)
    public ResponseEntity<String> handleCouponCodeSave(CouponCodeSaveException exception){
        return new ResponseEntity<>(exception.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(CouponCodeDeletionException.class)
    public ResponseEntity<String> handleCouponCodeDeletion(CouponCodeSaveException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
