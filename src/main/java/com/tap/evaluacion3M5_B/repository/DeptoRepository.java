/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tap.evaluacion3M5_B.repository;


import com.tap.evaluacion3M5_B.model.Depto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author chris
 */
public interface DeptoRepository extends MongoRepository<Depto, Long>{
    
}
