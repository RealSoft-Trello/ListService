package com.example.realsoft.list_service.service;

import com.example.realsoft.list_service.exception.ListNotFound;
import com.example.realsoft.list_service.model.ListDto;

public interface ListService {
    ListDto getList(Long listId) throws ListNotFound;
    ListDto createList(ListDto listDto);
    ListDto editList(Long listId, ListDto listDto) throws ListNotFound;
}
