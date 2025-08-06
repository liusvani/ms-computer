package com.computer.domain.port;


import com.computer.domain.model.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerDesktopRepository {
    Computer save(Computer computer);
    Optional<Computer> findById(Long id);

    List<Computer> findByMarca(String marca);
    Optional<Computer> findByInventario(String inventario);

}

