package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Language;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "geners")
@Slf4j
public class Gener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gener_id", nullable = false)
    private Integer id;

    @Column(name = "gener_name", nullable = false)
    private String generName;
@CreationTimestamp
    @Column(name = "CreatedAt", nullable = true, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
@UpdateTimestamp
    @Column(name = "UpdateAt", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
@PrePersist
public void beforeSave() {
 	log.info("Attempting to Add gener with name {} ",generName);	
 }
@PostPersist   
public void afterSave() {
	 
	 log.info("Gener with name {} with Id {} are added successfully at {} ",generName,id,createdAt);	
} 
@PostUpdate
public void afterUpdate() {
	 log.info("Gener with name {} with Id {} are Updated successfully at {} ",generName,id ,updatedAt);	
}
@PreUpdate
public void beforeUpdate() {
		log.info("Attempting to Update Gener with name {} ",generName);	
}
@PreRemove
public void afterDelete() {
	log.info("Attempting to Update Gener with name {} ",generName);	
}
@PostRemove
public void beforDelete() {
	
	 log.info("Gener with name {} with Id {} are Deleteded successfully at {} ",generName,id ,updatedAt);	
}
}