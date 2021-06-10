package com.example.kasper24timers.controller;


import com.example.kasper24timers.model.Kommune;
import com.example.kasper24timers.model.Sogn;
import com.example.kasper24timers.repository.KommuneRepository;
import com.example.kasper24timers.repository.SognRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestSognController {

    SognRepository sognRepository;
    KommuneRepository kommuneRepository;

    public RestSognController(SognRepository sognRepository,KommuneRepository kommuneRepository) {
        this.sognRepository = sognRepository;
        this.kommuneRepository = kommuneRepository;
    }

    @GetMapping("/sogn")
    public ResponseEntity<Iterable<Sogn>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sognRepository.findAll());
    }

    @GetMapping("/kommune")
    public ResponseEntity<Iterable<Kommune>> findAllkommune(){
        return ResponseEntity.status(HttpStatus.OK).body(kommuneRepository.findAll());
    }

    @GetMapping("/sogn/{id}")
    public ResponseEntity<Optional<Sogn>> findById(@PathVariable Long id) {
        Optional<Sogn> optionalSogn = sognRepository.findById(id);
        if (optionalSogn.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalSogn);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalSogn);
        }
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/sogn", consumes = "application/json")
    public Sogn create(@RequestBody Sogn s){

       return sognRepository.save(s);


       /*return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/sogn/" + s.getId())
                .body("{'Msg': 'Post created'}");*/

    }

    @PutMapping("/sogn/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Sogn s) {
        Optional<Sogn> optionalSogn = sognRepository.findById(id);
        if (!optionalSogn.isPresent()) {
            //Recipe id findes ikke
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogn " + id + " not found'");
        }
        //opdater category, ingredient og notes sker automatisk - nu er relationen oprettet
        //save recipe
        sognRepository.save(s);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'updated' }");
    }

    @DeleteMapping("/sogn/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Sogn> optionalSogn = sognRepository.findById(id);
        //check at opskriften findes
        if (!optionalSogn.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'msg' : 'sogn " + id + " not found'}");
        } else if (optionalSogn.isPresent()){
            sognRepository.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : " + id + " 'deleted'}");
    }



}
