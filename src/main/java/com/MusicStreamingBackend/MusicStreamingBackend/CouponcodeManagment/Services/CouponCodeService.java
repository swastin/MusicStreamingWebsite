package com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Services;

import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Dto.CouponcodeDto;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeDeletionException;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Exception.CouponCodeSaveException;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Models.Couponcode;
import com.MusicStreamingBackend.MusicStreamingBackend.CouponcodeManagment.Repositories.CouponcodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
//pivate static final org. slf4j. Logger log = org. slf4j. LoggerFactory. getLogger(LogExample. class);
public class CouponCodeService {
    @Autowired
    private CouponcodeRepository couponcodeRepository;

    private CouponcodeDto entityToDto(Couponcode couponcode) {
      return  new CouponcodeDto(couponcode.getId(),
              couponcode.getCode(),
              couponcode.getDiscountPercentage(),
              couponcode.getExpiryDate(),
              couponcode.getCreatedAt(),
              couponcode.getUpdatedAt()
      );

    }

    private Couponcode dtoToEntity(CouponcodeDto couponcodeDto) {
        Couponcode couponcode = new Couponcode();
        couponcode.setId(couponcodeDto.getId());
        couponcode.setCode(couponcodeDto.getCode());
        couponcode.setDiscountPercentage(couponcodeDto.getDiscountPercentage());
        couponcode.setExpiryDate(couponcodeDto.getExpiryDate());
        couponcode.setCreatedAt(couponcodeDto.getCreatedAt());
        couponcode.setUpdatedAt(couponcodeDto.getUpdatedAt());
        return couponcode;
    }

    public List<CouponcodeDto> getAllCouponCodes() {
        log.info("getAllCouponCodes");
        List<CouponcodeDto> AllCouponCodes = Optional.ofNullable(couponcodeRepository.findAll())
                .filter(codes -> !codes.isEmpty())
                .map(codes -> codes
                        .stream()
                        .map(this::entityToDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> {
                    log.error("Error occured ,coupon code not found !!");
                    return new CouponCodeNotFound("Couponcode not found");
                });
        log.info("total coupon code found{}", AllCouponCodes.size());
        return AllCouponCodes;
    }

    public CouponcodeDto getCouponCode(String code) {
        log.info("Fetching coupon code with code: {}", code);
        Optional<Couponcode> singleCode = couponcodeRepository.findByCode(code);
        return singleCode.map(this::entityToDto)
                .orElseThrow(() -> {
                    log.error("Error occured ,coupon code not found !!");
                    return new CouponCodeNotFound("Couponcode not found");
                });
    }

    public CouponcodeDto saveCouponCode(CouponcodeDto couponcodeDto) {
        try {
            Couponcode couponCodeEntity = dtoToEntity(couponcodeDto);
            Couponcode savedCouponCode = couponcodeRepository.save(couponCodeEntity);
            return entityToDto(savedCouponCode);
        } catch (Exception e) {
            log.error("Error saving coupon code: {}", couponcodeDto.getCode(), e);
            throw new CouponCodeSaveException("Failed to save coupon code: " + couponcodeDto.getCode(), e);
        }

    }

    public CouponcodeDto updateCouponCode(CouponcodeDto couponcodeDto) {
        try {
            Couponcode existingCouponCode = couponcodeRepository.findByCode(couponcodeDto.getCode())
                    .orElseThrow(() -> new CouponCodeNotFound("Couponcode not found"));

            existingCouponCode.setCode(couponcodeDto.getCode());
            existingCouponCode.setDiscountPercentage(couponcodeDto.getDiscountPercentage());
            existingCouponCode.setExpiryDate(couponcodeDto.getExpiryDate());
            Couponcode updatedCouponCode = couponcodeRepository.save(existingCouponCode);
            return entityToDto(updatedCouponCode);
        } catch (CouponCodeNotFound e) {
            log.error("Error updating coupon code: Coupon code not found - {}", couponcodeDto.getCode(), e);
            throw new CouponCodeNotFound("Couponcode not found");
        }

    }

    public void deleteCoupounCode(CouponcodeDto couponcodeDto) {

        try {
            // Step 1: Check if the coupon code exists in the database
            Couponcode existingCouponCode = couponcodeRepository.findByCode(couponcodeDto.getCode())
                    .orElseThrow(() -> new CouponCodeNotFound("Couponcode not found"));

            // Step 2: Delete the existing coupon code
            couponcodeRepository.delete(existingCouponCode);
            log.info("Deleted coupon code: {}", couponcodeDto.getCode());

        } catch (CouponCodeNotFound e) {
            log.error("Error deleting coupon code: Coupon code not found - {}", couponcodeDto.getCode(), e);
            throw e; // Rethrow to handle custom error response if needed
        } catch (Exception e) {
            log.error("Error deleting coupon code: {}", couponcodeDto.getCode(), e);
            throw new CouponCodeDeletionException("Failed to delete coupon code: " + couponcodeDto.getCode());
        }
    }
}
