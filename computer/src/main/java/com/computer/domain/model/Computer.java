package com.computer.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "computer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"inventario"}),
        @UniqueConstraint(columnNames = {"numero_serie"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String inventario;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(name = "numero_serie",nullable = false, unique = true)
    private String numeroSerie;

    @Column(nullable = false)
    private String procesador;

    @Column(name = "ram_gigabyte",nullable = false)
    private Integer ramGb;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ram",nullable = false)
    private ComputerRamType tipoRam;

    @Column(name = "almacenamiento_gb",nullable = false)
    private Integer almacenamientoGb;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComputerHardDiskType tipoAlmacenamiento;

    // Constructor adicional para test sin ID
    public Computer(String inventario, String numeroSerie) {
        this.inventario = inventario;
        this.numeroSerie = numeroSerie;
    }
}