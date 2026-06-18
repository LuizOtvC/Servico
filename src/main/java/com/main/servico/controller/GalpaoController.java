/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.controller;

import com.main.servico.model.Galpao;
import com.main.servico.model.Usuario;
import com.main.servico.service.GalpaoService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class GalpaoController {
    
    
    @Autowired
    private GalpaoService service;
    
    @GetMapping("/listar")
    public String listarGalpoes(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if(usuario == null){
            return "redirect:/login";
        }
        List<Galpao> galpoes = service.lerTodosGalpoesAtivos();
         model.addAttribute("galpao", galpoes);
         return "galpoes";
    }
    
    @GetMapping("/galpao/desativar/id")
    public String desativar(Model model, HttpSession session, Long id){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if(usuario == null){
            return "redirect:/login";
        }
        service.desativar(id);
        return "redirect:/listar";
    }
}
