/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.evaluacion3M5_B.controller;

import com.tap.evaluacion3M5_B.model.Depto;
import com.tap.evaluacion3M5_B.service.DeptoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/api/depto")
public class DeptoController {

    @Autowired
    DeptoService deptoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Depto>> listarProductos() {
        return new ResponseEntity<>(deptoService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Depto> crearProducto(
            @RequestBody Depto p) {
        return new ResponseEntity<>(deptoService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizarProducto(@PathVariable Long id, @RequestBody Depto p) {
        Depto deptoEncontrado = deptoService.findById(id);
        if (deptoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                
                deptoEncontrado.setNombre(p.getNombre());
                deptoEncontrado.setDirector(p.getDirector());
                deptoEncontrado.setDescripcion(p.getDescripcion());
                
                return new ResponseEntity<>(deptoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminarProducto(@PathVariable Long id) {
        deptoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
