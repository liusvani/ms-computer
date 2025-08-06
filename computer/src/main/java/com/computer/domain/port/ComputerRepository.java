package com.computer.domain.port;


import com.computer.domain.model.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerRepository  {
    Computer save(Computer computer);
    Optional<Computer> findById(Long id);
    List<Computer> findAll();
    boolean existsByInventario(String inventario);
    boolean existsByNumeroSerie(String serie);

    void deleteById(Long id);
    //Metodos personalizados
    List<Computer> findByMarca(String marca);
    Optional<Computer> findByInventario(String inventario);

}

