package com.example.realsoft.list_service.controller;

import com.example.realsoft.list_service.exception.ListNotFound;
import com.example.realsoft.list_service.model.ListDto;
import com.example.realsoft.list_service.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("realsoft/trello/lists")
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;

    @GetMapping("/{id}")
    public ResponseEntity<ListDto> getList(@PathVariable(name = "id") Long listId) throws ListNotFound {
        return ResponseEntity.ok(listService.getList(listId));
    }

    @PostMapping
    public ResponseEntity<ListDto> createList(@RequestBody ListDto listDto) {
        return new ResponseEntity<>(listService.createList(listDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListDto> editList(@PathVariable(name = "id") Long listId, @RequestBody ListDto listDto) throws ListNotFound {
        return ResponseEntity.ok(listService.editList(listId, listDto));
    }
}
