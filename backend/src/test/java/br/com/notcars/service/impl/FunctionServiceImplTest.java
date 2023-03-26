package br.com.notcars.service.impl;

import br.com.notcars.exceptions.NotFoundException;
import br.com.notcars.model.FunctionEntity;
import br.com.notcars.repository.FunctionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FunctionServiceImplTest {

    @Mock
    private FunctionRepository functionRepository;

    @InjectMocks
    private FunctionServiceImpl functionService;

    @Test
    @DisplayName("should throw a NotFoundException when the id is not found")
    void findByIdWhenIdIsNotFoundThenThrowNotFoundException() {
        when(functionRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());
        assertThrows(NotFoundException.class, () -> functionService.findById(1L));
    }

    @Test
    @DisplayName("should return the function entity when the id is found")
    void findByIdWhenIdIsFound() {
        FunctionEntity functionEntity = new FunctionEntity();
        functionEntity.setId(1L);
        functionEntity.setName("name");
        when(functionRepository.findById(anyLong()))
                .thenReturn(java.util.Optional.of(functionEntity));

        FunctionEntity result = functionService.findById(1L);

        assertEquals(1L, result.getId());
        assertEquals("name", result.getName());
    }
}