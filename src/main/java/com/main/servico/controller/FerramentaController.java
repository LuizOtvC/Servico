/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.controller;


import com.main.servico.model.Ferramenta;
import com.main.servico.repository.FerramentaRepository;
import com.main.servico.service.FerramentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Aluno
 */
@Controller
public class FerramentaController {
    
    @Autowired
     private FerramentaService service;
    
    @GetMapping("/ferramentas")
    public String ListarFerramentas(Model model) {
        List<Ferramenta> listaFerramentas = service.lerTodos();
        
       model.addAttribute("listaFerramentas", listaFerramentas);
       return "listaFerramentas";
                
    }
    @GetMapping("/criar")
    public String criarFerramenta(Model model){
        model.addAttribute("ferramenta", new Ferramenta());
        return "criar";
}
    @PostMapping("/criar")
    public String novaFerramenta(@ModelAttribute("ferramenta") Ferramenta tool, Model model){
        service.register(tool);
            return "redirect:/listaFerramentas";
    }
    @GetMapping("/deletar/{id}")
    public String deletarFerramenta(@PathVariable long id) {
    service.deletar(id);
    return "redirect:/listaFerramentas";
}
    @GetMapping("/editar/{id}")
public String editarFerramenta(@PathVariable Long id, Model model){
    Ferramenta ferramenta = service.buscarPorId(id);
    model.addAttribute("ferramenta", ferramenta);
    return "editar";
}

@PostMapping("/editar")
public String salvarEdicao(@ModelAttribute("ferramenta") Ferramenta tool, Model model){
    service.Salvar(tool);
    return "redirect:/listaFerramentas";
}
    
   
    
}
