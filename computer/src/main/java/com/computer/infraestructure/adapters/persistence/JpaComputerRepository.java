package com.computer.infraestructure.adapters.persistence;


import com.computer.domain.model.Computer;
import com.computer.domain.port.ComputerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaComputerRepository extends JpaRepository<Computer, Long> {
    boolean existsByInventario(String inventario);
    boolean existsByNumeroSerie(String numeroSerie);
    List<Computer> findByMarca(String marca);
    Optional<Computer> findByInventario(String inventario);



}
