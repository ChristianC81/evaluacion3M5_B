/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.evaluacion3M5_B.controller;


import com.tap.evaluacion3M5_B.model.Curso;
import com.tap.evaluacion3M5_B.service.CursoService;
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
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarProductos() {
        return new ResponseEntity<>(cursoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Curso> crearProducto(
            @RequestBody Curso p) {
        return new ResponseEntity<>(cursoService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarProducto(@PathVariable Long id, @RequestBody Curso p) {
        Curso cursoEncontrado = cursoService.findById(id);
        if (cursoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cursoEncontrado.setProf_Id(p.getProf_Id());
                cursoEncontrado.setNombre(p.getNombre());
                cursoEncontrado.setNivel(p.getNivel());
                cursoEncontrado.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(cursoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminarProducto(@PathVariable Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}