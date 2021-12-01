package com.pruebassaber311.generararchivos.controllers;

import com.pruebassaber311.generararchivos.dtos.Item;
import com.pruebassaber311.generararchivos.services.IProcesarArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/GenerarArchivos")
public class GenerarArchivosController {

    @Autowired
    IProcesarArchivoService service;

    @PostMapping("/")
    public void obtenerArchivo(@RequestBody List<Item> items) {
        service.Crear(items);
    }
}
