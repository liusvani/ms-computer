package com.computer.infraestructure.adapters.persistence;


import com.computer.domain.model.Computer;
import com.computer.domain.port.ComputerDesktopRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaComputerDesktopRepository extends JpaRepository<Computer, Long>, ComputerDesktopRepository {
}
