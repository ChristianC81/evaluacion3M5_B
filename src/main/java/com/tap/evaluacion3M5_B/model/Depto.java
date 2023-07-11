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
@Document(collection="Depto")
@Data
public class Depto {
     @Id
    private Long depto_Id;
    
    private String nombre;
  
    private String director;
    
    private String descripcion;
    
}
