package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Gener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gener_id", nullable = false)
    private Integer id;

    @Column(name = "gener_name", nullable = false)
    private String generName;

    @Column(name = "CreatedAt", nullable = true, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

}