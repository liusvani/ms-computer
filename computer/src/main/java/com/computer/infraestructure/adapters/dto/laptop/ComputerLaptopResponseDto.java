package com.computer.infraestructure.adapters.dto.laptop;

import com.computer.infraestructure.adapters.dto.computer.ComputerResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ComputerLaptopResponseDto extends ComputerResponseDto {

    private String bateria;
    private String peso;
    private String webcam;
}
