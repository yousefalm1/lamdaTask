package com.example.lamdaTask.controller;

import com.example.lamdaTask.entities.GuestSuggestionEntity;
import com.example.lamdaTask.service.GuestSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions/status")
@RequiredArgsConstructor
public class SuggestionStatusController {

    private final GuestSuggestionService guestSuggestionService;

    @GetMapping("/created")
    public ResponseEntity<List<GuestSuggestionEntity>> getAllCreatedSuggestions() {
        List<GuestSuggestionEntity> suggestions = guestSuggestionService.findAllCreatedSuggestions();
        return new ResponseEntity<>(suggestions, HttpStatus.OK);
    }

    @GetMapping("/removed")
    public ResponseEntity<List<GuestSuggestionEntity>> getAllRemovedSuggestions() {
        List<GuestSuggestionEntity> suggestions = guestSuggestionService.findAllRemovedSuggestions();
        return ResponseEntity.ok(suggestions);
    }
}
