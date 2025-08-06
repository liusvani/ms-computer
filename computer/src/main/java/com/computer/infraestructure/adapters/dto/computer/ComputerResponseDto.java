package com.computer.infraestructure.adapters.dto.computer;

import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopResponseDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopResponseDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ComputerLaptopResponseDto.class, name = "laptop"),
        @JsonSubTypes.Type(value = ComputerDesktopResponseDto.class, name = "desktop")
})
@Data
public abstract  class ComputerResponseDto {

    private Long id;
    private String inventario;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String procesador;
    private Integer ramGb;
    private String tipoRam;
    private Integer almacenamientoGb;
    private String tipoAlmacenamiento;
}
