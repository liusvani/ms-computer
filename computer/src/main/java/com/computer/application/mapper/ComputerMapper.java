package com.computer.application.mapper;



import com.computer.domain.model.ComputerDesktop;
import com.computer.domain.model.ComputerLaptop;
import com.computer.infraestructure.adapters.dto.computer.ComputerRequestDto;
import com.computer.infraestructure.adapters.dto.computer.ComputerResponseDto;
import com.computer.domain.model.Computer;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopResponseDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopResponseDto;
public class ComputerMapper {

    public static ComputerResponseDto toDto(Computer computer) {
        if (computer instanceof ComputerLaptop laptop) {
            ComputerLaptopResponseDto dto = new ComputerLaptopResponseDto();
            // setear campos comunes
            setCommonFields(dto, laptop);
            // setear campos específicos
            dto.setBateria(laptop.getBateria());
            dto.setPeso(String.valueOf(laptop.getPeso()));
            dto.setWebcam(laptop.getWebcam());
            return dto;
        } else if (computer instanceof ComputerDesktop desktop) {
            ComputerDesktopResponseDto dto = new ComputerDesktopResponseDto();
            setCommonFields(dto, desktop);
            dto.setTorre(desktop.getTorre());
            dto.setMonitor(desktop.getMonitor());
            dto.setFuente(desktop.getFuente());
            return dto;
        } else {
            throw new IllegalArgumentException("Tipo de computadora desconocido");
        }
    }

    private static void setCommonFields(ComputerResponseDto dto, Computer computer) {
        dto.setId(computer.getId());
        dto.setInventario(computer.getInventario());
        dto.setMarca(computer.getMarca());
        dto.setModelo(computer.getModelo());
        dto.setNumeroSerie(computer.getNumeroSerie());
        dto.setProcesador(computer.getProcesador());
        dto.setRamGb(computer.getRamGb());
        dto.setTipoRam(String.valueOf(computer.getTipoRam()));
        dto.setAlmacenamientoGb(computer.getAlmacenamientoGb());
        dto.setTipoAlmacenamiento(String.valueOf(computer.getTipoAlmacenamiento()));
    }
    public static Computer toEntity(ComputerRequestDto dto) {
        Computer computer = new Computer();
        computer.setInventario(dto.getInventario());
        computer.setMarca(dto.getMarca());
        computer.setModelo(dto.getModelo());
        computer.setNumeroSerie(dto.getNumero_serie());
        computer.setProcesador(dto.getProcesador());
        computer.setRamGb(dto.getRamGb());
        computer.setTipoRam(dto.getTipo_ram());
        computer.setAlmacenamientoGb(dto.getAlmacenamiento_gb());
        computer.setTipoAlmacenamiento(dto.getTipoAlmacenamiento());
        return computer;
    }
}


