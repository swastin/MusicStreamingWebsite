package com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Service;

import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Dto.SubscriptionplanDto;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Exceptions.*;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Models.Subscriptionplan;
import com.MusicStreamingBackend.MusicStreamingBackend.SubscriptionPlanManagment.Repositories.SubscriptionplanRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubscriptionplanService {

    @Autowired
    private SubscriptionplanRepository subscriptionplanRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Subscriptionplan subscriptionplanDtoToSubscriptionplan(SubscriptionplanDto subscriptionplanDto) {
        log.debug("Mapping SubscriptionplanDto to Subscriptionplan entity: {}", subscriptionplanDto);
        return modelMapper.map(subscriptionplanDto, Subscriptionplan.class);
    }

    public SubscriptionplanDto subscriptionplanTosubscriptionplanDto(Subscriptionplan subscriptionPlan) {
        log.debug("Mapping Subscriptionplan entity to SubscriptionplanDto: {}", subscriptionPlan);
        return modelMapper.map(subscriptionPlan, SubscriptionplanDto.class);
    }

    public SubscriptionplanDto saveSubscriptionplan(SubscriptionplanDto subscriptionplanDto) throws SubscriptionplanSaveException {
        log.info("Saving a new subscription plan: {}", subscriptionplanDto.getPlanName());
        try {
            Subscriptionplan subscriptionplan = subscriptionplanDtoToSubscriptionplan(subscriptionplanDto);
            Subscriptionplan savedSubscriptionPlan = subscriptionplanRepository.save(subscriptionplan);
            SubscriptionplanDto savedDto = subscriptionplanTosubscriptionplanDto(savedSubscriptionPlan);
            log.info("Subscription plan saved successfully: {}", savedDto.getPlanName());
            return savedDto;
        } catch (Exception e) {
            log.error("Error saving subscription plan: {}", subscriptionplanDto.getPlanName(), e);
            throw new SubscriptionplanSaveException("Could not save subscription plan: " + subscriptionplanDto.getPlanName());
        }
    }

    public List<SubscriptionplanDto> getAllSubscriptionplans() throws subscriptionplanNotFound {
        log.info("Fetching all subscription plans");
        List<Subscriptionplan> subscriptionplans = subscriptionplanRepository.findAll();

        if (subscriptionplans.isEmpty()) {
            log.error("No subscription plans found.");
            throw new subscriptionplanNotFound("Subscription plans not found");
        }

        List<SubscriptionplanDto> result = subscriptionplans.stream()
                .map(this::subscriptionplanTosubscriptionplanDto)
                .collect(Collectors.toList());
        log.info("Found {} subscription plans.", result.size());
        return result;
    }

    public SubscriptionplanDto getSubscriptionplanByName(String planName) throws subscriptionplanNotFound {
        log.info("Fetching subscription plan by name: {}", planName);
        Optional<Subscriptionplan> optionalPlan = subscriptionplanRepository.findByPlanName(planName);

        return optionalPlan.map(this::subscriptionplanTosubscriptionplanDto)
                .orElseThrow(() -> {
                    log.error("Subscription plan with name {} not found", planName);
                    return new subscriptionplanNotFound("Subscription plan not found");
                });
    }

    public SubscriptionplanDto updateSubscriptionplan(SubscriptionplanDto subscriptionplanDto) throws SubscriptionplanUpdateException, subscriptionplanNotFound {
        log.info("Updating subscription plan: {}", subscriptionplanDto.getPlanName());
        try {
            Subscriptionplan subscriptionplan = subscriptionplanRepository.findByPlanName(subscriptionplanDto.getPlanName())
                    .orElseThrow(() -> {
                        log.error("Subscription plan with name {} not found for update", subscriptionplanDto.getPlanName());
                        return new subscriptionplanNotFound("Subscription plan not found");
                    });

            subscriptionplan.setPlanName(subscriptionplanDto.getPlanName());
            subscriptionplan.setPrice(subscriptionplanDto.getPrice());
            subscriptionplan.setDurationMonths(subscriptionplanDto.getDurationMonths());
            subscriptionplan.setCreatedAt(subscriptionplanDto.getCreatedAt());
            subscriptionplan.setUpdatedAt(subscriptionplanDto.getUpdatedAt());

            Subscriptionplan updatedSubscriptionPlan = subscriptionplanRepository.save(subscriptionplan);
            SubscriptionplanDto updatedDto = subscriptionplanTosubscriptionplanDto(updatedSubscriptionPlan);
            log.info("Subscription plan updated successfully: {}", updatedDto.getPlanName());
            return updatedDto;
        } catch (Exception e) {
            log.error("Error updating subscription plan: {}", subscriptionplanDto.getPlanName(), e);
            throw new SubscriptionplanUpdateException("Could not update subscription plan: " + subscriptionplanDto.getPlanName());
        }
    }

    public void deleteSubscriptionplan(SubscriptionplanDto subscriptionplanDto) throws SubscriptionplanDeleteException, subscriptionplanNotFound {
        log.info("Deleting subscription plan: {}", subscriptionplanDto.getPlanName());
        try {
            Subscriptionplan subscriptionplan = subscriptionplanRepository.findByPlanName(subscriptionplanDto.getPlanName())
                    .orElseThrow(() -> {
                        log.error("Subscription plan with name {} not found for deletion", subscriptionplanDto.getPlanName());
                        return new subscriptionplanNotFound("Subscription plan not found");
                    });

            subscriptionplanRepository.delete(subscriptionplan);
            log.info("Subscription plan deleted successfully: {}", subscriptionplanDto.getPlanName());
        } catch (Exception e) {
            log.error("Error deleting subscription plan: {}", subscriptionplanDto.getPlanName(), e);
            throw new SubscriptionplanDeleteException("Could not delete subscription plan: " + subscriptionplanDto.getPlanName(), e);
        }
    }
}
