package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Dto.LanguageDto;
import com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Services.LanguageService;

@RestController
@RequestMapping("api/languages")
public class LanguageRestController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAllLanguages() {
        List<LanguageDto> allLanguages = languageService.getAllLanguages();
        return ResponseEntity.ok(allLanguages);
    }

    @GetMapping("/{name}")
    public ResponseEntity<LanguageDto> getLanguage(@PathVariable("name") String name) {
        LanguageDto getLanguage = languageService.getlanguage(name);
        return ResponseEntity.ok(getLanguage);
    }

    @PostMapping("/save")
    public ResponseEntity<LanguageDto> saveLanguage(@RequestBody LanguageDto languageDto) {
        LanguageDto savedLanguage = languageService.saveLanguage(languageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLanguage);
    }

    @PutMapping("/update")
    public ResponseEntity<LanguageDto> updateLanguage(@RequestBody LanguageDto languageDto) {
        LanguageDto updatedLanguage = languageService.updateLanguage(languageDto);
        return ResponseEntity.ok(updatedLanguage);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<LanguageDto> deleteLanguage(@RequestBody LanguageDto languageDto){
     languageService.deleteLanguage(languageDto);
    return ResponseEntity.noContent().build();
    		
    }
}
