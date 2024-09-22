package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Controllers;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Dto.CouponcodeDto;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Services.CouponCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponCodeRestController {
    @Autowired
    private CouponCodeService couponCodeService;

    @GetMapping
    public ResponseEntity<List<CouponcodeDto>> getAllCoupons() {
        List<CouponcodeDto> allCouponCodes = couponCodeService.getAllCouponCodes();
        return ResponseEntity.ok(allCouponCodes);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CouponcodeDto> getCouponCode(@PathVariable String code) {
        CouponcodeDto couponCode = couponCodeService.getCouponCode(code);
        return ResponseEntity.ok(couponCode);
    }

    @PostMapping
    public ResponseEntity<CouponcodeDto> saveCouponCode(@RequestBody CouponcodeDto couponCodeDto) {
        CouponcodeDto savedCouponCode = couponCodeService.saveCouponCode(couponCodeDto);
        return new ResponseEntity<>(savedCouponCode, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<CouponcodeDto> updateCouponCode(@PathVariable String code, @RequestBody CouponcodeDto couponCodeDto) {
        couponCodeDto.setCode(code);
        CouponcodeDto updatedCouponCode = couponCodeService.updateCouponCode(couponCodeDto);
        return ResponseEntity.ok(updatedCouponCode);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCouponCode(@PathVariable String code) {
        CouponcodeDto couponCode = new CouponcodeDto();
        couponCode.setCode(code);
        couponCodeService.deleteCoupounCode(couponCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



