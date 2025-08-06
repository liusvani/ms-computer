package com.computer.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "computer_desktop")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "computer_id")
public class ComputerDesktop extends Computer {

    @Column(name = "torre", nullable = false)
    private String torre;

    @Column(name = "monitor", nullable = false)
    private String monitor;

    @Column(name = "fuente", nullable = false)
    private String fuente;
}
