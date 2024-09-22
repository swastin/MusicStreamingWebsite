package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Exceptions;

public class LanguageNameNotFound extends RuntimeException {
	public LanguageNameNotFound(String name){
		super(name);
	}
}
