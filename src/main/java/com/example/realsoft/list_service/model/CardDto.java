package com.example.realsoft.list_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {
    private Long cardId;
    private String title;
    private Long listId;
    private String description;
    private LocalDate createdAt;
}
