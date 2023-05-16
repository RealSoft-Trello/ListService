package com.example.realsoft.list_service.service.imp;

import com.example.realsoft.list_service.entity.List;
import com.example.realsoft.list_service.exception.ListNotFound;
import com.example.realsoft.list_service.model.ListDto;
import com.example.realsoft.list_service.repository.ListRepository;
import com.example.realsoft.list_service.service.ListService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ListServiceImp implements ListService {
    private final ListRepository listRepository;
    private final ModelMapper modelMapper;

    @Override
    public ListDto getList(Long listId) throws ListNotFound {
        return modelMapper.map(findList(listId), ListDto.class);
    }

    @Override
    public ListDto createList(ListDto listDto) {
        List list = new List();
        list.setTitle(listDto.getTitle());
        list.setBoardId(listDto.getBoardId());
        list.setCreatedAt(LocalDate.now());
        listRepository.save(list);
        return modelMapper.map(list, ListDto.class);
    }

    @Override
    public ListDto editList(Long listId, ListDto listDto) throws ListNotFound {
        List list = findList(listId);
        list.setTitle(listDto.getTitle());
        listRepository.save(list);
        return modelMapper.map(list, ListDto.class);
    }

    private List findList(Long listId) throws ListNotFound {
        return listRepository.findById(listId).orElseThrow(() ->
                new ListNotFound("Id", listId));
    }
}
