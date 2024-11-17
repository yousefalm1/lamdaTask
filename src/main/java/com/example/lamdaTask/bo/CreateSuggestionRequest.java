package com.example.lamdaTask.bo;

import com.example.lamdaTask.enums.SuggestionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSuggestionRequest {
    private Double rate;
    private String suggestionText;
    private SuggestionStatus status;

}
