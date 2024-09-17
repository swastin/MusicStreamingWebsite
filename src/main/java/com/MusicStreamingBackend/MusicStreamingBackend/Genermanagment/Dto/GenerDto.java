package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerDto implements Serializable {
    Integer id;
    String generName;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}