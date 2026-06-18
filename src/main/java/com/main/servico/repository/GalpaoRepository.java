/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.repository;

import com.main.servico.model.Galpao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class GalpaoRepository {
    
     public List<Galpao> ListarAtivos(){
        List<Galpao> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM galpao WHERE ativo = 1");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Galpao galpao = new Galpao();
                galpao.setId(rs.getLong("id"));
                galpao.setNome(rs.getString("nome"));
                galpao.setAtivo(rs.getBoolean("ativo"));
                
                
                dados.add(galpao);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
         return dados;   
    }
     
     public void desativar(Long id){
         int linhas = 0;
         try{
             Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement("update galpao set ativo = 0 where id = ?");
             stmt.setLong(1, id);
            
            linhas = stmt.executeUpdate();
            if (linhas == 0) {
                throw new SQLException("Falha na atualização: Nenhuma linha foi afetada.");
            }
             
             
         }catch(SQLException e){
             e.printStackTrace();
         }
     }
}
