package com.computer.application;

import com.computer.domain.model.Computer;
import com.computer.infraestructure.handler.BusinessException;
import com.computer.domain.port.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    private final ComputerRepository repository;

    public ComputerService(ComputerRepository repository) {
        this.repository = repository;
    }
    public Computer crearComputer(Computer computer) {
        validarInventarioUnico(computer.getInventario());
        validarNumeroSerieUnico(computer.getNumeroSerie());
        return repository.save(computer);
    }
    public List<Computer> listarComputadoras() {
        return repository.findAll();
    }
    public Optional<Computer> obtenerPorId(Long id) {
        return repository.findById(id);
    }
    public boolean eliminarComputer(Long id) {
        Optional<Computer> computer = repository.findById(id);
        if (computer.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private void validarInventarioUnico(String inventario) {
        if (repository.existsByInventario(inventario)) {
            throw new BusinessException("El inventario '" + inventario + "' existe en la bd.");
        }
    }

    private void validarNumeroSerieUnico(String numeroSerie) {
        if (repository.existsByNumeroSerie(numeroSerie)) {
            throw new BusinessException("El número de serie '" + numeroSerie + "' existe en la bd.");
        }
    }
}