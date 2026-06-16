/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.service;

import com.main.servico.model.Ferramenta;
import com.main.servico.repository.FerramentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class FerramentaService {
    
    @Autowired
    private FerramentaRepository service;
    
    public List<Ferramenta> lerTodos(){
       return service.listarFerramentas();   
    }
    
    public void register(Ferramenta tool){
        service.register(tool);
    }
    public void deletar(Long id){
        service.deletar(id);
    }
    public void Salvar(Ferramenta ferramenta){
        service.Salvar(ferramenta);
    }
    
    public Ferramenta buscarPorId(Long id) {
    return service.buscarPorId(id);
}

}
