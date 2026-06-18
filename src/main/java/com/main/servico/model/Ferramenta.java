/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.servico.model;

import java.math.BigInteger;

/**
 *
 * @author Aluno
 */
public class Ferramenta {
    
    private Long id;
    private String nome;
    private Integer horasDeUso;
    private Integer vidaUtilMaxima;
    private String status;
    private Long idGalpao;
    private Long idUsuarioResponsavel;

    public Ferramenta() {
    }

    public Ferramenta(Long id, String nome, Integer horasDeUso, Integer vidaUtilMaxima, String status, Long idGalpao, Long idUsuarioResponsavel) {
        this.id = id;
        this.nome = nome;
        this.horasDeUso = horasDeUso;
        this.vidaUtilMaxima = vidaUtilMaxima;
        this.status = status;
        this.idGalpao = idGalpao;
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHorasDeUso() {
        return horasDeUso;
    }

    public void setHorasDeUso(Integer horasDeUso) {
        this.horasDeUso = horasDeUso;
    }

    public Integer getVidaUtilMaxima() {
        return vidaUtilMaxima;
    }

    public void setVidaUtilMaxima(Integer vidaUtilMaxima) {
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdGalpao() {
        return idGalpao;
    }

    public void setIdGalpao(Long idGalpao) {
        this.idGalpao = idGalpao;
    }

    public Long getIdUsuarioResponsavel() {
        return idUsuarioResponsavel;
    }

    public void setIdUsuarioResponsavel(Long idUsuarioResponsavel) {
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }

    
}