/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.service;

import com.main.servico.model.Ferramenta;
import com.main.servico.repository.FerramentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if(tool.getNome().equals("")){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Nome não encontrado");
        }
        if(tool.getVidaUtilMaxima() <= 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Vida util não encontrada");
        }
        if(tool.getHorasDeUso() < 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "horas de uso não encontradas");
        }
        int linhas = service.register(tool);
        if(linhas == 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao adicionar ao banco de dados");
        }
    }
    public void deletar(Long id){
        int linhas = service.deletar(id);
        if(linhas == 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao deletar do banco de dados");
        }
    }
    public void Salvar(Ferramenta tool){
        if(tool.getNome().equals("")){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Nome não encontrado");
        }
        if(tool.getVidaUtilMaxima() <= 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Vida util não encontrada");
        }
        if(tool.getHorasDeUso() < 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "horas de uso não encontradas");
        }
        int linhas = service.Salvar(tool);
        if(linhas == 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao atualizar o banco de dados");
        }
    }
    
    public Ferramenta buscarPorId(Long id) {
    return service.buscarPorId(id);
}

}
