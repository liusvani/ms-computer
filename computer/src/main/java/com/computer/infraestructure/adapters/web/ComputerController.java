package com.computer.infraestructure.adapters.web;


import com.computer.application.ComputerService;
import com.computer.application.mapper.ComputerDesktopMapper;
import com.computer.application.mapper.ComputerLaptopMapper;
import com.computer.domain.model.ComputerDesktop;
import com.computer.domain.model.ComputerLaptop;
import com.computer.infraestructure.adapters.dto.computer.ComputerRequestDto;
import com.computer.infraestructure.adapters.dto.computer.ComputerResponseDto;
import com.computer.application.mapper.ComputerMapper;
import com.computer.domain.model.Computer;
import com.computer.infraestructure.adapters.dto.desktop.ComputerDesktopRequestDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopRequestDto;
import com.computer.infraestructure.adapters.dto.laptop.ComputerLaptopResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    private final ComputerService service;

    public ComputerController(ComputerService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> crearComputadora(@Valid @RequestBody ComputerRequestDto dto) {
        try {
            String tipo_computer = "desktop".equals(dto.getTipo()) ? "de escritorio" : "portátil";

            Map<String, Object> response = new HashMap<>();

            if (dto instanceof ComputerLaptopRequestDto laptopDto) {
                ComputerLaptop laptop = ComputerLaptopMapper.toEntity(laptopDto);
                ComputerLaptop creada = (ComputerLaptop) service.crearComputer(laptop);
                response.put("data", ComputerLaptopMapper.toDto(creada));
            } else if (dto instanceof ComputerDesktopRequestDto desktopDto) {
                ComputerDesktop desktop = ComputerDesktopMapper.toEntity(desktopDto);
                ComputerDesktop creada = (ComputerDesktop) service.crearComputer(desktop);
                response.put("data", ComputerDesktopMapper.toDto(creada));
            } else {
                return ResponseEntity.badRequest().body(Map.of("error", "Tipo de computadora no reconocido"));
            }

            response.put("message", "Computadora "+tipo_computer+" creada exitosamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al crear la computadora", "details", e.getMessage()));
        }
    }


    // Listar todas las computadoras
    @GetMapping
    public List<ComputerResponseDto> listar() {
        return service.listarComputadoras()
                .stream()
                .map(ComputerMapper::toDto)
                .collect(Collectors.toList());
    }


    // Obtener computadora por ID
    @GetMapping("/{id}")
    public ComputerResponseDto obtener(@PathVariable Long id) {
        Computer computer = service.obtenerPorId(id).orElseThrow();
        return ComputerMapper.toDto(computer);
    }

    // Eliminar computadora por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            boolean eliminado = service.eliminarComputer(id);

            if (eliminado) {
                return ResponseEntity.ok(Map.of("message", "Computadora eliminada exitosamente", "id", id));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "No se encontró una computadora con el ID especificado "+id+" ." ));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al intentar eliminar la computadora", "details", e.getMessage()));
        }
    }

}

