package com.computer.infraestructure.adapters.persistence;

import com.computer.domain.model.Computer;
import com.computer.domain.port.ComputerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ComputerRepositoryAdapter implements ComputerRepository {

    private final JpaComputerRepository jpaRepository;

    public ComputerRepositoryAdapter(JpaComputerRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Computer> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public boolean existsByInventario(String inventario) {
        return jpaRepository.existsByInventario(inventario);
    }

    @Override
    public boolean existsByNumeroSerie(String serie) {
        return jpaRepository.existsByNumeroSerie(serie);
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return jpaRepository.save(computer);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Computer> findByMarca(String marca) {
        return jpaRepository.findByMarca(marca);
    }

    @Override
    public Optional<Computer> findByInventario(String inventario) {
        return jpaRepository.findByInventario(inventario);
    }

}

