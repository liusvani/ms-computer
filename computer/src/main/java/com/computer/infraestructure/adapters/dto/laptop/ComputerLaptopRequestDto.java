package com.computer.infraestructure.adapters.dto.laptop;

import com.computer.infraestructure.adapters.dto.computer.ComputerRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ComputerLaptopRequestDto extends ComputerRequestDto {

    private String tipo = "laptop";

    @NotBlank(message = "La descrpición de la batería es olbigatorio (mAh, modelo y marca).")
    private String bateria;

    @NotNull(message = "Debe especificar el peso de la laptop en KG.")
    @Positive(message = "El peso debe ser mayor que cero.")
    private Double peso;

    @NotBlank(message = "Debe especificar si la laptop cuenta con webcam y su mayor resolución.")
    private String webcam;
}
