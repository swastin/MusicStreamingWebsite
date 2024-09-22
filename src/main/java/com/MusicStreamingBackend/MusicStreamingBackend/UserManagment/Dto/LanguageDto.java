package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Dto;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Language}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto implements Serializable {
    private   Integer id;
    private   String languageName;
    private   LocalDateTime createdAt;
    private   LocalDateTime updatedAt;
}