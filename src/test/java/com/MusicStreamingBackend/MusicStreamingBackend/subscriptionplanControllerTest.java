package com.MusicStreamingBackend.MusicStreamingBackend;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Controller.SubscriptionplanController;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Dto.SubscriptionplanDto;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanSaveException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.SubscriptionplanUpdateException;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.subscriptionplanNotFound;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Service.SubscriptionplanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SubscriptionplanController.class)
class SubscriptionplanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriptionplanService subscriptionplanService;

    @Autowired
    private ObjectMapper objectMapper;

    private SubscriptionplanDto subscriptionplanDto;

    @BeforeEach
    void setUp() {
        subscriptionplanDto = new SubscriptionplanDto();
        subscriptionplanDto.setPlanName("Premium Plan");
        subscriptionplanDto.setPrice(BigDecimal.valueOf(499.99));
        subscriptionplanDto.setDurationMonths(12);
    }

    @Test
    void createSubscriptionPlan_Success() throws Exception, SubscriptionplanSaveException {
        when(subscriptionplanService.saveSubscriptionplan(any(SubscriptionplanDto.class))).thenReturn(subscriptionplanDto);

        mockMvc.perform(post("/api/subscriptionplans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(subscriptionplanDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.planName").value("Premium Plan"))
                .andExpect(jsonPath("$.price").value(499.99));
    }

    @Test
    void getAllSubscriptionPlans_Success() throws Exception {
        List<SubscriptionplanDto> subscriptionPlans = Arrays.asList(subscriptionplanDto);
        when(subscriptionplanService.getAllSubscriptionplans()).thenReturn(subscriptionPlans);

        mockMvc.perform(get("/api/subscriptionplans"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].planName").value("Premium Plan"));
    }

    @Test
    void getSubscriptionPlanByName_Success() throws Exception {
        when(subscriptionplanService.getSubscriptionplanByName(anyString())).thenReturn(subscriptionplanDto);

        mockMvc.perform(get("/api/subscriptionplans/Premium Plan"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.planName").value("Premium Plan"))
                .andExpect(jsonPath("$.price").value(499.99));
    }

    @Test
    void getSubscriptionPlanByName_NotFound() throws Exception {
        when(subscriptionplanService.getSubscriptionplanByName(anyString())).thenThrow(new subscriptionplanNotFound("Plan not found"));

        mockMvc.perform(get("/api/subscriptionplans/InvalidPlan"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Plan not found"));
    }

    @Test
    void updateSubscriptionPlan_Success() throws Exception, SubscriptionplanUpdateException {
        when(subscriptionplanService.updateSubscriptionplan(any(SubscriptionplanDto.class))).thenReturn(subscriptionplanDto);

        mockMvc.perform(put("/api/subscriptionplans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(subscriptionplanDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.planName").value("Premium Plan"));
    }

    @Test
    void deleteSubscriptionPlan_Success() throws Exception {
        doNothing().when(subscriptionplanService).deleteSubscriptionplan(any(SubscriptionplanDto.class));

        mockMvc.perform(delete("/api/subscriptionplans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(subscriptionplanDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Subscription plan deleted successfully"));
    }

    @Test
    void deleteSubscriptionPlan_NotFound() throws Exception {
        doThrow(new subscriptionplanNotFound("Plan not found")).when(subscriptionplanService).deleteSubscriptionplan(any(SubscriptionplanDto.class));

        mockMvc.perform(delete("/api/subscriptionplans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(subscriptionplanDto)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Plan not found"));
    }
}
