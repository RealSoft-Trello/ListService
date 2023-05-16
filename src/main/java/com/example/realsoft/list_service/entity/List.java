package com.example.realsoft.list_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long listId;

    private String title;
    private Long boardId;
    private LocalDate createdAt;
}
