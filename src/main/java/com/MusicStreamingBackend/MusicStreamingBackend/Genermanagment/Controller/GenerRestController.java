package com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Controller;

import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Dto.GenerDto;
import com.MusicStreamingBackend.MusicStreamingBackend.Genermanagment.Services.GenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/geners")
public class GenerRestController {
 @Autowired
 private GenerService generService;
// @GetMapping("/{id}")
// public ResponseEntity<GenerDto> getgenerByid(@PathVariable int id) {
//  GenerDto genreById = generService.getGenreById(id);
//  return ResponseEntity.ok(genreById);
//
// }
 @GetMapping
 public  ResponseEntity<List<GenerDto>> getAllGener(){

  List<GenerDto> allGenre = generService.getAllGenre();
  return ResponseEntity.ok(allGenre);
 }
 @GetMapping("/{name}")
 public ResponseEntity<GenerDto> getgenerByname(@PathVariable String name) {
  GenerDto genreByName = generService.getGenreByName(name);
  return ResponseEntity.ok(genreByName);

 }
 @GetMapping("/search")
 public ResponseEntity<GenerDto> searchGenreByName(@RequestParam("name") String name) {
  GenerDto gener = generService.searchGenreByName(name);
  return ResponseEntity.ok(gener);
 }
 @PostMapping("/save")
 public ResponseEntity<GenerDto> savegener(@RequestBody GenerDto generDto) {
  GenerDto savedgener = generService.saveGener(generDto);
  return ResponseEntity.status(HttpStatus.CREATED).body(savedgener);
 }

 // Endpoint to update a gener
 @PutMapping("/update")
 public ResponseEntity<GenerDto> updategener(@RequestBody GenerDto generDto) {
  GenerDto updatedgener = generService.updateGener(generDto);
  return ResponseEntity.ok(updatedgener);
 }

 // Endpoint to delete a gener
 @DeleteMapping("/delete")
 public ResponseEntity<Void> deletegener(@RequestBody GenerDto generDto) {
  generService.deleteGener(generDto);
  return ResponseEntity.noContent().build();
 }
}
