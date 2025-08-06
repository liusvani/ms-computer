package com.computer.application.mapper;

import com.computer.domain.model.Computer;
import com.computer.infraestructure.adapters.dto.computer.ComputerRequestDto;
import com.computer.infraestructure.adapters.dto.computer.ComputerResponseDto;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopRequestDto;
import com.computer.domain.model.ComputerDesktop;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopResponseDto;

public class ComputerDesktopMapper {
    public static ComputerDesktop toEntity(ComputerDesktopRequestDto dto) {
        ComputerDesktop computerDesktop = new ComputerDesktop();

        // Campos comunes
        computerDesktop.setInventario(dto.getInventario());
        computerDesktop.setMarca(dto.getMarca());
        computerDesktop.setModelo(dto.getModelo());
        computerDesktop.setNumeroSerie(dto.getNumero_serie());
        computerDesktop.setProcesador(dto.getProcesador());
        computerDesktop.setRamGb(dto.getRamGb());
        computerDesktop.setTipoRam(dto.getTipo_ram());
        computerDesktop.setAlmacenamientoGb(dto.getAlmacenamiento_gb());
        computerDesktop.setTipoAlmacenamiento(dto.getTipoAlmacenamiento());

        computerDesktop.setTorre(dto.getFuente());
        computerDesktop.setMonitor(dto.getMonitor());
        computerDesktop.setFuente(dto.getFuente());
        return computerDesktop;
    }

    public static ComputerDesktopResponseDto toDto(ComputerDesktop computerDesktop) {
        ComputerDesktopResponseDto dto = new ComputerDesktopResponseDto();

        // Campos comunes
        dto.setId(computerDesktop.getId());
        dto.setInventario(computerDesktop.getInventario());
        dto.setMarca(computerDesktop.getMarca());
        dto.setModelo(computerDesktop.getModelo());
        dto.setNumeroSerie(computerDesktop.getNumeroSerie());
        dto.setProcesador(computerDesktop.getProcesador());
        dto.setRamGb(computerDesktop.getRamGb());
        dto.setTipoRam(String.valueOf(computerDesktop.getTipoRam()));
        dto.setAlmacenamientoGb(computerDesktop.getAlmacenamientoGb());
        dto.setTipoAlmacenamiento(String.valueOf(computerDesktop.getTipoAlmacenamiento()));

        // Campos comunes
        dto.setTorre(computerDesktop.getTorre());
        dto.setMonitor(computerDesktop.getMonitor());
        dto.setFuente(computerDesktop.getFuente());
        return dto;
    }
}
