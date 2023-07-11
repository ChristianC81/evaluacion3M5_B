/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.evaluacion3M5_B.service;

import com.tap.evaluacion3M5_B.model.Depto;
import com.tap.evaluacion3M5_B.repository.DeptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class DeptoServiceImpl extends GenericServiceImpl<Depto, Long> implements DeptoService{

    @Autowired
    DeptoRepository deptoRepository;
    
    @Override
    public CrudRepository<Depto, Long> getDao() {
        return deptoRepository;
    }
    
}
