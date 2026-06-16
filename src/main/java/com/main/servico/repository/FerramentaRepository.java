/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.repository;

import com.main.servico.model.Ferramenta;
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
public class FerramentaRepository {
    
    
    public List<Ferramenta> listarFerramentas(){
        List<Ferramenta> ferramenta = new ArrayList<>();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM equipamento");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Ferramenta tool = new Ferramenta();
                tool.setId(rs.getInt("id"));
                tool.setNome(rs.getString("nome"));
                tool.setHorasDeUso(rs.getInt("horas_uso"));
                tool.setVidaUtilMaxima(rs.getInt("vida_util"));
                
                ferramenta.add(tool);
            
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ferramenta;
    }
    public void register(Ferramenta tool){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("INSERT INTO equipamento (nome, horas_uso, vida_util) VALUES (?, ?, ?)");
            stmt.setString(1, tool.getNome());
            stmt.setInt(2, tool.getHorasDeUso());
            stmt.setInt(3, tool.getVidaUtilMaxima());
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha na atualização: Nenhuma linha foi afetada.");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void deletar(Long id){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("DELETE FROM equipamento WHERE id = ?");
            stmt.setLong(1, id);
                
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha na atualização: Nenhuma linha foi afetada.");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void Salvar(Ferramenta ferramenta){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("UPDATE equipamento SET nome = ?, horas_uso = ?, vida_util = ? WHERE id = ? ");
            
  
                stmt.setString(1, ferramenta.getNome());
                stmt.setInt(2, ferramenta.getHorasDeUso());
                stmt.setInt(3, ferramenta.getVidaUtilMaxima());
                stmt.setInt(4, ferramenta.getId());
                
                
                 stmt.executeUpdate();
            
    }catch (SQLException e){
           e.printStackTrace();
        }
}
    public Ferramenta buscarPorId(Long id){
    Ferramenta ferramenta = null;
    try{
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM equipamento WHERE id = ?");
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            ferramenta = new Ferramenta();
            ferramenta.setId(rs.getInt("id"));
            ferramenta.setNome(rs.getString("nome"));
            ferramenta.setHorasDeUso(rs.getInt("horas_uso"));
            ferramenta.setVidaUtilMaxima(rs.getInt("vida_util"));
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    return ferramenta;
}
    
}
