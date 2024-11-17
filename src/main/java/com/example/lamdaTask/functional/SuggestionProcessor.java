package com.example.lamdaTask.functional;

@FunctionalInterface
public interface SuggestionProcessor {
    void processSuggestion(String suggestionText, double rate);
}