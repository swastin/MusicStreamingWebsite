package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Dto;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Dto.GenerDto;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models.Preference}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceDto implements Serializable {
    public  Integer id;
    public  User user;
    public  GenerDto genre;
    public  LanguageDto language;
    public  LocalDateTime createdAt;
    public  LocalDateTime updatedAt;
}