package com.computer;

import com.computer.domain.model.Computer;
import com.computer.domain.port.ComputerRepository;
import com.computer.application.ComputerService;
import com.computer.infraestructure.handler.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputerServiceTest {

    @Mock
    private ComputerRepository repository;

    @InjectMocks
    private ComputerService service;

    @Test
    void debeCrearComputadora() {
        Computer comp = new Computer();
        comp.setInventario("C001");
        comp.setNumeroSerie("S001");

        when(repository.existsByInventario("C001")).thenReturn(false);
        when(repository.existsByNumeroSerie("S001")).thenReturn(false);
        when(repository.save(comp)).thenReturn(comp);

        Computer resultado = service.crearComputer(comp);

        assertEquals("C001", resultado.getInventario());
        verify(repository).save(comp);
    }

    @Test
    void noDebeCrearComputadoraSiInventarioYaExiste() {
        Computer comp = new Computer();
        comp.setInventario("C001");
        comp.setNumeroSerie("S002");

        when(repository.existsByInventario("C001")).thenReturn(true);

        BusinessException ex = assertThrows(BusinessException.class, () -> service.crearComputer(comp));
        assertEquals("El inventario 'C001' existe en la bd.", ex.getMessage());
    }

    @Test
    void noDebeCrearComputadoraSiNumeroSerieYaExiste() {
        Computer comp = new Computer();
        comp.setInventario("C002");
        comp.setNumeroSerie("S001");

        when(repository.existsByInventario("C002")).thenReturn(false);
        when(repository.existsByNumeroSerie("S001")).thenReturn(true);

        BusinessException ex = assertThrows(BusinessException.class, () -> service.crearComputer(comp));
        assertEquals("El número de serie 'S001' existe en la bd.", ex.getMessage());
    }

    @Test
    void debeObtenerComputadoraPorId() {
        Long id = 1L;
        Computer comp = new Computer();
        comp.setId(id);
        comp.setInventario("C003");

        when(repository.findById(id)).thenReturn(Optional.of(comp));

        Optional<Computer> resultado = service.obtenerPorId(id);

        assertEquals("C003", resultado.get().getInventario());
    }

    @Test
    void noDebeObtenerComputadoraSiIdNoExiste() {
        Long id = 99L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        Optional<Computer> resultado = service.obtenerPorId(id);

        assertEquals(Optional.empty(), resultado);
    }

    @Test
    void debeEliminarComputadoraSiExiste() {
        Long id = 2L;
        Computer comp = new Computer();
        comp.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(comp));

        boolean eliminado = service.eliminarComputer(id);

        assertEquals(true, eliminado);
        verify(repository).deleteById(id);
    }

    @Test
    void noDebeEliminarComputadoraSiNoExiste() {
        Long id = 3L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        boolean eliminado = service.eliminarComputer(id);

        assertEquals(false, eliminado);
    }

    @Test
    void debeListarTodasLasComputadoras() {
        List<Computer> lista = List.of(
                new Computer("C001", "S001"),
                new Computer("C002", "S002")
        );

        when(repository.findAll()).thenReturn(lista);

        List<Computer> resultado = service.listarComputadoras();

        assertEquals(2, resultado.size());
        assertEquals("C001", resultado.get(0).getInventario());
    }



}


