package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Advice;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenerControllerAdvice {
	@ExceptionHandler(GenernotfoundException.class)
	public ResponseEntity<String> handleGenernotFound(GenernotfoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(GenernamenotfoundException.class)
	public ResponseEntity<String> handleGenernamenotfound(GenernamenotfoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(GenernotSavedException.class)
	public ResponseEntity<String> handleGenernotSaved(GenernotSavedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(GenernotUpdatedException.class)
	public ResponseEntity<String> handleGenernotUpdated(GenernotUpdatedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(GenernotdeletedException.class)
	public ResponseEntity<String> handleGenernotdeleted(GenernotdeletedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
