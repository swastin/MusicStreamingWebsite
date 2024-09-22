package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Advice;

import com.MusicStreamingBackend.MusicStreamingBackend.utility.ApiErrorResponse;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeDeletionException;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeSaveException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CouponCodeControllerAdvice {

    @ExceptionHandler(CouponCodeNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleCouponCodeNotFound(CouponCodeNotFound exception) {
        log.error("Coupon code not found: {}", exception.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CouponCodeSaveException.class)
    public ResponseEntity<ApiErrorResponse> handleCouponCodeSave(CouponCodeSaveException exception) {
        log.error("Error saving coupon code: {}", exception.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CouponCodeDeletionException.class)
    public ResponseEntity<ApiErrorResponse> handleCouponCodeDeletion(CouponCodeDeletionException exception) {
        log.error("Error deleting coupon code: {}", exception.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception exception) {
        log.error("An unexpected error occurred: {}", exception.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred. Please try again later.",LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
