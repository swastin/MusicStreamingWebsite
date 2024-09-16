package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception;

public class CouponCodeSaveException extends RuntimeException {
public CouponCodeSaveException(String message, Exception e){
    super(message);
}
}
