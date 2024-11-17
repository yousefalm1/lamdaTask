package com.example.lamdaTask.functional;

import com.example.lamdaTask.enums.SuggestionStatus;

@FunctionalInterface
public interface SuggestionProcessor {
    void processSuggestion(String suggestionText, double rate, SuggestionStatus suggestionStatus);
}