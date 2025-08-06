package com.computer.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "computer_laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "computer_id")
public class ComputerLaptop extends Computer {

    @Column(name = "bateria", nullable = false)
    private String bateria;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "webcam", nullable = false)
    private String webcam;
}
