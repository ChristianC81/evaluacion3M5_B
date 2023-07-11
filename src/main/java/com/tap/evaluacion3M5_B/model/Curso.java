/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.evaluacion3M5_B.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author chris
 */
@Document(collection="Curso")
@Data
public class Curso {
 
    @Id
    private Long curso_Id;
    
    private Profesor prof_Id;

    private String nombre;
  
    private String nivel;
    
    private String descripcion;
    
}   
