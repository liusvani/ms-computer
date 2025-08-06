package com.computer.infraestructure.adapters.dto.computer;

import com.computer.domain.model.ComputerHardDiskType;
import com.computer.domain.model.ComputerRamType;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopRequestDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopRequestDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import jakarta.validation.constraints.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ComputerLaptopRequestDto.class, name = "laptop"),
        @JsonSubTypes.Type(value = ComputerDesktopRequestDto.class, name = "desktop")
})
@Data
public abstract class ComputerRequestDto {
    public abstract String getTipo(); // laptop o desktop

    @NotBlank(message = "El campo inventario no puede estar vacío")
    @Size(max = 50, message = "El inventario no puede tener más de 50 caracteres")
    private String inventario;

    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 30, message = "La marca no puede tener más de 30 caracteres")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    @Size(max = 30, message = "El modelo no puede tener más de 30 caracteres")
    private String modelo;

    @NotBlank(message = "El número de serie es obligatorio")
    @Size(max = 50, message = "El número de serie no puede tener más de 50 caracteres")
    private String numero_serie;

    @NotBlank(message = "El procesador es obligatorio")
    @Size(max = 50, message = "El procesador no puede tener más de 50 caracteres")
    private String procesador;

    @NotNull(message = "La cantidad de RAM es obligatoria")
    @Min(value = 1, message = "La RAM debe ser al menos de 1 GB")
    @Max(value = 1024, message = "La RAM no puede exceder 1024 GB")
    private Integer ramGb;

    private ComputerRamType tipo_ram;

    @NotNull(message = "El almacenamiento es obligatorio")
    @Min(value = 16, message = "El almacenamiento debe ser al menos de 16 GB")
    @Max(value = 8192, message = "El almacenamiento no puede exceder 8192 GB")
    private Integer almacenamiento_gb;

    @Enumerated(EnumType.STRING)
    private ComputerHardDiskType tipoAlmacenamiento;
}


