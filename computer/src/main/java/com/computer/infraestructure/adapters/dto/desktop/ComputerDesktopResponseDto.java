package com.computer.infraestructure.adapters.dto.desktop;

import com.computer.infraestructure.adapters.dto.computer.ComputerResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ComputerDesktopResponseDto extends ComputerResponseDto {

    private String torre;
    private String monitor;
    private String fuente;
}
