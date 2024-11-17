package com.example.lamdaTask.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSuggestionRequest {
    private Double rate;
    private String suggestionText;

}
