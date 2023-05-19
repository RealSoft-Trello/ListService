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
import java.util.stream.Collectors;

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
        list.setListId(listDto.getListId());
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

    @Override
    public java.util.List<ListDto> getListsByBoardId(Long boardId) {
        return listRepository.getListsByBoardId(boardId).stream()
                .map(list -> modelMapper.map(list, ListDto.class))
                .collect(Collectors.toList());
    }

    private List findList(Long listId) throws ListNotFound {
        return listRepository.findById(listId).orElseThrow(() ->
                new ListNotFound("Id", listId));
    }
}
