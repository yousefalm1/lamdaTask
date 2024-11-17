package com.example.lamdaTask.entities;

import com.example.lamdaTask.enums.SuggestionStatus;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "guest_suggestions")
@Getter
@Setter
@NoArgsConstructor
public class GuestSuggestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rate;

    @Column(name = "suggestion_text")
    private String suggestionText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SuggestionStatus status;

}
