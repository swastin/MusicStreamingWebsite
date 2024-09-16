package com.MusicStreamingBackend.MusicStreamingBackend;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Dto.CouponcodeDto;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Services.CouponCodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest

public class CouponCodeServiceTest {
    @Autowired
    private CouponCodeService couponCodeService;

    @Test
    public void saveCouponCode() {
        CouponcodeDto ccd = new CouponcodeDto();
        ccd.setId(1);
        ccd.setCode("SALE20");
        ccd.setExpiryDate(LocalDate.of(2024, 9, 16));
        ccd.setDiscountPercentage(BigDecimal.valueOf(0.2));
        ccd.setCreatedAt(LocalDateTime.now());
        ccd.setUpdatedAt(LocalDateTime.now());
        couponCodeService.saveCouponCode(ccd);

    }
}