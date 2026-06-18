/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.service;

import com.main.servico.model.Galpao;
import com.main.servico.repository.GalpaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class GalpaoService {
    
    @Autowired
    private GalpaoRepository galpao;
    
    public List<Galpao> lerTodosGalpoesAtivos(){
        return galpao.ListarAtivos();
    }
    public void desativar(Long id){
        galpao.desativar(id);
    }
}
