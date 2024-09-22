package com.MusicStreamingBackend.MusicStreamingBackend.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
	  	private HttpStatus status;
	    private String message;
	    private String timestamp=LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);   
	    }


