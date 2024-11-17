package com.example.lamdaTask.service;

import com.example.lamdaTask.entities.GuestSuggestionEntity;
import com.example.lamdaTask.enums.SuggestionStatus;
import com.example.lamdaTask.functional.SuggestionProcessor;
import com.example.lamdaTask.repositories.GuestSuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestSuggestionService
{
    private final GuestSuggestionRepository guestSuggestionRepository;

    public void printAndProcessSuggestion(String suggestionText, Double rate, SuggestionStatus suggestionStatus) {

        SuggestionProcessor processSuggestion = (suggestion, rating, status) -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestion);
            suggestionEntity.setRate(rating);
            suggestionEntity.setStatus(status);

            guestSuggestionRepository.save(suggestionEntity);
        };

        System.out.println("Processing suggestion: " + suggestionText + rate + suggestionStatus);
        processSuggestion.processSuggestion(suggestionText, rate, suggestionStatus);
    }

    public List<GuestSuggestionEntity> findAllCreatedSuggestions() {
        return guestSuggestionRepository.findAll() // Gets all the suggestions from the database
                .stream() //converts the list into a stream so you can process each item one by one
                .filter(suggestion -> suggestion.getStatus() == SuggestionStatus.CREATE)
                // filter looks at each suggestion
                // uses lamda to keep the only ones with the CREATE status
                .collect(Collectors.toList()); // takes the filtered items from the stream and collects them back into a list
    }


    public List<GuestSuggestionEntity> findAllRemovedSuggestions() {
        return guestSuggestionRepository.findAll()
                .stream()
                .filter(suggestion -> suggestion.getStatus() == SuggestionStatus.REMOVE)
                .collect(Collectors.toList());
    }
}
