/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.controller;

import com.main.servico.model.Usuario;
import com.main.servico.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

/**
 *
 * @author Aluno
 */
@Controller
public class UserController {
    @Autowired
    private UsuarioService usuario;
    
    private String extrairMensagemDeErro(HttpClientErrorException e) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(e.getResponseBodyAsString());
            if (root.has("message")) {
                return root.get("message").asText();
            }
        } catch (Exception ex) {
        }
        return "Ocorreu um erro inesperado na comunicação.";
    }
    
    @GetMapping("/login")
    public String paginaLogin(Model model) {
        model.addAttribute("user", new Usuario());
        return "logar";
    }
    @PostMapping("/login")
    public String fazerLogin(@ModelAttribute Usuario user, HttpSession session, Model model) {    
        try{
            Usuario logado = usuario.logar(user.getLogin(), user.getSenha());
            if(logado.getId() != null && logado.getLogin() != null){
                session.setAttribute("usuarioLogado", logado);
                return "redirect:/home"; 
            }else{
                model.addAttribute("erro", "Login ou senha inválidos");
            model.addAttribute("user", new Usuario());
            return "logar"; 
            }
        }catch (HttpClientErrorException e) {
            String msg = extrairMensagemDeErro(e);
            model.addAttribute("errorMessage", msg);
            model.addAttribute("credenciais", user);
            return "logar";
        }         
            
            
    }
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
        if(logado == null){            
        return "redirect:/login";
        }       
        model.addAttribute("usuario", logado);
       return "home";
    } 
    @GetMapping("/logout")
    public String logout(HttpSession session) {
       session.invalidate();
    return "redirect:/login";
}
}
