package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Controller;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Dto.SubscriptionplanDto;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanSaveException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanUpdateException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Service.SubscriptionplanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/subscriptionplans")
@Slf4j
public class SubscriptionplanController {

    @Autowired
    private SubscriptionplanService subscriptionplanService;

    @PostMapping
    public ResponseEntity<SubscriptionplanDto> createSubscriptionPlan(@RequestBody SubscriptionplanDto subscriptionplanDto) throws Exception, SubscriptionplanSaveException {
        log.info("Received request to create a subscription plan: {}", subscriptionplanDto.getPlanName());
        SubscriptionplanDto savedPlan = subscriptionplanService.saveSubscriptionplan(subscriptionplanDto);
        return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionplanDto>> getAllSubscriptionPlans() throws Exception {
        log.info("Received request to get all subscription plans.");
        List<SubscriptionplanDto> subscriptionPlans = subscriptionplanService.getAllSubscriptionplans();
        return new ResponseEntity<>(subscriptionPlans, HttpStatus.OK);
    }

    @GetMapping("/{planName}")
    public ResponseEntity<SubscriptionplanDto> getSubscriptionPlanByName(@PathVariable String planName) throws Exception {
        log.info("Received request to fetch subscription plan by name: {}", planName);
        SubscriptionplanDto subscriptionPlan = subscriptionplanService.getSubscriptionplanByName(planName);
        return new ResponseEntity<>(subscriptionPlan, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SubscriptionplanDto> updateSubscriptionPlan(@RequestBody SubscriptionplanDto subscriptionplanDto) throws Exception, SubscriptionplanUpdateException {
        log.info("Received request to update subscription plan: {}", subscriptionplanDto.getPlanName());
        SubscriptionplanDto updatedPlan = subscriptionplanService.updateSubscriptionplan(subscriptionplanDto);
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSubscriptionPlan(@RequestBody SubscriptionplanDto subscriptionplanDto) throws Exception {
        log.info("Received request to delete subscription plan: {}", subscriptionplanDto.getPlanName());
        subscriptionplanService.deleteSubscriptionplan(subscriptionplanDto);
        return new ResponseEntity<>("Subscription plan deleted successfully", HttpStatus.OK);
    }
}

