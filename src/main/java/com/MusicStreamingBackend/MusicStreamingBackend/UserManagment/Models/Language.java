package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
@Slf4j
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false)
    private Integer id;

    @Column(name = "language_name", nullable = false)
    private String languageName;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
    @PrePersist
public void beforeSave() {
    	log.info("Attempting to Add Language with name {} ",languageName);	
    }
 @PostPersist   
public void afterSave() {
	 
	 log.info("Language with name {} with Id {} are added successfully at {} ",languageName,id,createdAt);	
 } 
 @PostUpdate
public void afterUpdate() {
	 log.info("Language with name {} with Id {} are Updated successfully at {} ",languageName,id ,updatedAt);	
 }
 @PreUpdate
public void beforeUpdate() {
		log.info("Attempting to Update Language with name {} ",languageName);	
 }

@PostRemove
public void afterDelete() {
	log.info("Attempting to Delete Language with name {} ",languageName);	
}
@PreRemove
public void beforDelete() {
	
	 log.info("Language with name {} with Id {} are Deleteded successfully at {} ",languageName,id ,updatedAt);	
}
}