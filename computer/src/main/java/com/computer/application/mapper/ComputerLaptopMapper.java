package com.computer.application.mapper;

import com.computer.domain.model.ComputerDesktop;
import com.computer.domain.model.ComputerLaptop;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopRequestDto;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopResponseDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopRequestDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopResponseDto;

public class ComputerLaptopMapper {

    public static ComputerLaptop toEntity(ComputerLaptopRequestDto dto) {
        ComputerLaptop laptop = new ComputerLaptop();

        // Campos comunes
        laptop.setInventario(dto.getInventario());
        laptop.setMarca(dto.getMarca());
        laptop.setModelo(dto.getModelo());
        laptop.setNumeroSerie(dto.getNumero_serie());
        laptop.setProcesador(dto.getProcesador());
        laptop.setRamGb(dto.getRamGb());
        laptop.setTipoRam(dto.getTipo_ram());
        laptop.setAlmacenamientoGb(dto.getAlmacenamiento_gb());
        laptop.setTipoAlmacenamiento(dto.getTipoAlmacenamiento());

        // Campos específicos
        laptop.setBateria(dto.getBateria());
        laptop.setPeso(dto.getPeso());
        laptop.setWebcam(dto.getWebcam());

        return laptop;
    }

    public static ComputerLaptopResponseDto toDto(ComputerLaptop laptop) {
        ComputerLaptopResponseDto dto = new ComputerLaptopResponseDto();

        // Campos comunes
        dto.setId(laptop.getId());
        dto.setInventario(laptop.getInventario());
        dto.setMarca(laptop.getMarca());
        dto.setModelo(laptop.getModelo());
        dto.setNumeroSerie(laptop.getNumeroSerie());
        dto.setProcesador(laptop.getProcesador());
        dto.setRamGb(laptop.getRamGb());
        dto.setTipoRam(String.valueOf(laptop.getTipoRam()));
        dto.setAlmacenamientoGb(laptop.getAlmacenamientoGb());
        dto.setTipoAlmacenamiento(String.valueOf(laptop.getTipoAlmacenamiento()));

        // Campos específicos
        dto.setBateria(laptop.getBateria());
        dto.setPeso(String.valueOf(laptop.getPeso()));
        dto.setWebcam(laptop.getWebcam());

        return dto;
    }
}
