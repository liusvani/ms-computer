package com.computer.infraestructure.adapters.dto.desktop;

import com.computer.infraestructure.adapters.dto.computer.ComputerRequestDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComputerDesktopRequestDto extends ComputerRequestDto {

    private String tipo = "desktop";

    @NotBlank(message = "Debe especificar alguna descripción de la torre.")
    private String torre;

    @NotBlank(message = "Debe especificar alguna descripción de el monitor.")
    private String monitor;

    @NotBlank(message = "Debe especificar alguna descripción de la fuente.")
    private String fuente;
}
