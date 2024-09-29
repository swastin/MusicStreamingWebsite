package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Advice;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanDeleteException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanSaveException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanUpdateException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.subscriptionplanNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.utility.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@ControllerAdvice
public class SubscriptionPlanControllerAdvice {
    @ExceptionHandler(subscriptionplanNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleSubscriptionPlanNotFoundException(subscriptionplanNotFound ex) {
        ApiErrorResponse response = new ApiErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SubscriptionplanSaveException.class)
    public ResponseEntity<ApiErrorResponse> handleSubscriptionPlanSaveException(SubscriptionplanSaveException ex) {
        ApiErrorResponse response = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SubscriptionplanUpdateException.class)
    public ResponseEntity<ApiErrorResponse> handleSubscriptionPlanUpdateException(SubscriptionplanUpdateException ex) {
        ApiErrorResponse response = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SubscriptionplanDeleteException.class)
    public ResponseEntity<ApiErrorResponse> handleSubscriptionPlanDeleteException(SubscriptionplanDeleteException ex) {
        ApiErrorResponse response = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGlobalException(Exception ex) {
        ApiErrorResponse response = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + ex.getMessage(),LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
