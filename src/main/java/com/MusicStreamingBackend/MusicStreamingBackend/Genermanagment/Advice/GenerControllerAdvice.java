package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Advice;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.*;
import com.MusicStreamingBackend.MusicStreamingBackend.utility.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GenerControllerAdvice {

	@ExceptionHandler(GenernotfoundException.class)
	public ResponseEntity<ApiErrorResponse> handleGenernotFound(GenernotfoundException exception) {
		ApiErrorResponse response = new ApiErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GenernamenotfoundException.class)
	public ResponseEntity<ApiErrorResponse> handleGenernamenotfound(GenernamenotfoundException exception) {
		ApiErrorResponse response = new ApiErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GenernotSavedException.class)
	public ResponseEntity<ApiErrorResponse> handleGenernotSaved(GenernotSavedException exception) {
		ApiErrorResponse response = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(GenernotUpdatedException.class)
	public ResponseEntity<ApiErrorResponse> handleGenernotUpdated(GenernotUpdatedException exception) {
		ApiErrorResponse response = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(GenernotdeletedException.class)
	public ResponseEntity<ApiErrorResponse> handleGenernotdeleted(GenernotdeletedException exception) {
		ApiErrorResponse response = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
