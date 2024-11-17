package com.example.lamdaTask.service;

import com.example.lamdaTask.entities.GuestSuggestionEntity;
import com.example.lamdaTask.functional.SuggestionProcessor;
import com.example.lamdaTask.repositories.GuestSuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestSuggestionService
{
    private final GuestSuggestionRepository guestSuggestionRepository;

    public void printAndProcessSuggestion(String suggestionText, Double rate) {

        SuggestionProcessor processSuggestion = (suggestion, rating) -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestion);
            suggestionEntity.setRate(rating);
            guestSuggestionRepository.save(suggestionEntity);
        };

        System.out.println("Processing suggestion: " + suggestionText + rate);
        processSuggestion.processSuggestion(suggestionText, rate);
    }


}
