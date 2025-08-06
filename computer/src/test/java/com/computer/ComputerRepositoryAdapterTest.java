package com.computer;

import com.computer.domain.model.Computer;
import com.computer.domain.port.ComputerRepository;
import com.computer.infraestructure.adapters.persistence.ComputerRepositoryAdapter;
import com.computer.infraestructure.adapters.persistence.JpaComputerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComputerRepositoryAdapterTest {

    @Mock
    private JpaComputerRepository jpaRepository;

    @InjectMocks
    private ComputerRepositoryAdapter adapter;

    @Test
    void debeGuardarComputer() {
        Computer computer = new Computer("C001", "S001");
        when(jpaRepository.save(computer)).thenReturn(computer);

        Computer resultado = adapter.save(computer);

        assertEquals("C001", resultado.getInventario());
        verify(jpaRepository).save(computer);
    }

    @Test
    void debeListarComputadoras() {
        List<Computer> lista = List.of(
                new Computer("C001", "S001"),
                new Computer("C002", "S002")
        );
        when(jpaRepository.findAll()).thenReturn(lista);

        List<Computer> resultado = adapter.findAll();

        assertEquals(2, resultado.size());
        verify(jpaRepository).findAll();
    }

    @Test
    void debeEncontrarPorId() {
        Computer computer = new Computer("C001", "S001");
        when(jpaRepository.findById(1L)).thenReturn(Optional.of(computer));

        Optional<Computer> resultado = adapter.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("C001", resultado.get().getInventario());
        verify(jpaRepository).findById(1L);
    }

    @Test
    void debeEliminarPorId() {
        adapter.deleteById(1L);
        verify(jpaRepository).deleteById(1L);
    }

    @Test
    void debeVerificarInventarioExistente() {
        when(jpaRepository.existsByInventario("C001")).thenReturn(true);

        boolean existe = adapter.existsByInventario("C001");

        assertTrue(existe);
        verify(jpaRepository).existsByInventario("C001");
    }

    @Test
    void debeVerificarNumeroSerieExistente() {
        when(jpaRepository.existsByNumeroSerie("S001")).thenReturn(true);

        boolean existe = adapter.existsByNumeroSerie("S001");

        assertTrue(existe);
        verify(jpaRepository).existsByNumeroSerie("S001");
    }
}
