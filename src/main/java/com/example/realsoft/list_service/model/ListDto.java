package com.example.realsoft.list_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ListDto {
    private Long listId;
    private String title;
    private Long boardId;
    private LocalDate createdAt;
}
