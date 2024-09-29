package com.MusicStreamingBackend.MusicStreamingBackend;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Dto.SubscriptionplanDto;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanSaveException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanUpdateException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Models.Subscriptionplan;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Repositories.SubscriptionplanRepository;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Service.SubscriptionplanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SubscriptionplanServiceTest {
    @Autowired
    private SubscriptionplanRepository subscriptionplanRepository;
    @Autowired
    private SubscriptionplanService subscriptionplanService;

    @Test
    @Rollback(false)
    void testCreatePlan() throws SubscriptionplanSaveException {
        // Create a new subscription plan
        SubscriptionplanDto subscriptionplan = new SubscriptionplanDto();
        subscriptionplan.setPlanName("Premium Plan");
        subscriptionplan.setPrice(BigDecimal.valueOf(499.99));
        subscriptionplan.setDurationMonths(12);

        // Calling the service method
        SubscriptionplanDto createdPlan = subscriptionplanService.saveSubscriptionplan(subscriptionplan);

        // Assertions to check the behavior
        assertThat(createdPlan).isNotNull();
        assertThat(createdPlan.getPlanName()).isEqualTo("Premium Plan");
    }

    @Test
    void testGetPlanByName() throws SubscriptionplanUpdateException {
        // Calling the service method
        SubscriptionplanDto foundPlan = subscriptionplanService.getSubscriptionplanByName("Premium Plan");
        assertThat(foundPlan).isNotNull();
        assertThat(foundPlan.getPlanName()).isEqualTo("Premium Plan");
    }
    @Test
    void testUpdatePlan() throws SubscriptionplanUpdateException {
        // Create and save a subscription plan first
        // Create a new subscription plan object for updating
        SubscriptionplanDto updatedPlan = new SubscriptionplanDto();
        updatedPlan.setPlanName("Premium Plan");
        updatedPlan.setPrice(BigDecimal.valueOf(599.99));
        updatedPlan.setDurationMonths(124);

        // Calling the service method to update the plan
        SubscriptionplanDto result = subscriptionplanService.updateSubscriptionplan(  updatedPlan);

        // Assertions to check the updated values
        assertThat(result.getPrice()).isEqualTo(BigDecimal.valueOf(599.99));
        assertThat(result.getDurationMonths()).isEqualTo(124);
    }
//
//    @Test
//    void testDeletePlan() {
//        // Create and save a subscription plan first
//        Subscriptionplan subscriptionplan = new Subscriptionplan();
//        subscriptionplan.setPlanName("Premium Plan");
//        subscriptionplan.setPrice(499.99);
//        subscriptionplan.setDuration("12 months");
//        subscriptionplanRepository.save(subscriptionplan);
//
//        // Call the service method to delete the plan
//        subscriptionplanService.deletePlan("Premium Plan");
//
//        // Verify that the plan no longer exists
//        Optional<Subscriptionplan> deletedPlan = subscriptionplanService.getPlanByName("Premium Plan");
//        assertThat(deletedPlan).isNotPresent();
//    }
}
