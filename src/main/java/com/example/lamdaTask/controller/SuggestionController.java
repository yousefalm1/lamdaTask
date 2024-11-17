package com.example.lamdaTask.controller;


import com.example.lamdaTask.bo.CreateSuggestionRequest;
import com.example.lamdaTask.repositories.GuestSuggestionRepository;
import com.example.lamdaTask.service.GuestSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suggestions")
@RequiredArgsConstructor
public class SuggestionController {
    private final GuestSuggestionService guestSuggestionService;


    @PostMapping
    public ResponseEntity<String> handleSuggestion(@RequestBody CreateSuggestionRequest request) {
        guestSuggestionService.printAndProcessSuggestion(request.getSuggestionText(), request.getRate());
        return ResponseEntity.ok("Suggestion processed successfully!");
    }

}