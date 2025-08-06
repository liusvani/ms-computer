package com.computer.infraestructure.adapters.web;

import com.computer.application.mapper.ComputerDesktopMapper;
import com.computer.application.mapper.ComputerLaptopMapper;
import com.computer.application.mapper.ComputerMapper;
import com.computer.domain.model.Computer;
import com.computer.domain.model.ComputerDesktop;
import com.computer.domain.model.ComputerLaptop;
import com.computer.infraestructure.adapters.dto.computer.ComputerRequestDto;
import com.computer.infraestructure.adapters.dto.computer.ComputerResponseDto;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopRequestDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ComputerFactory {

    public static Computer mapToEntity(ComputerRequestDto dto) {
        if (dto instanceof ComputerDesktopRequestDto desktopDto) {
            return ComputerDesktopMapper.toEntity(desktopDto);
        } else if (dto instanceof ComputerLaptopRequestDto laptopDto) {
            return ComputerLaptopMapper.toEntity(laptopDto);
        }  else {
            return ComputerMapper.toEntity(dto);
        }
    }

    public static ComputerResponseDto mapToDto(Computer computer) {
        if (computer instanceof ComputerDesktop desktop) {
            return ComputerDesktopMapper.toDto(desktop);
        } else if (computer instanceof ComputerLaptop laptop) {
            return ComputerLaptopMapper.toDto(laptop);
        } else {
            return ComputerMapper.toDto(computer);
        }
    }
}

