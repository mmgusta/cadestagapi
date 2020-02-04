package com.qintess.cadestag.controllers;

import java.util.List;

import com.qintess.cadestag.models.SituacaoAtual;
import com.qintess.cadestag.repositories.SituacaoAtualRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SituacaoAtualController {

    @Autowired
    private SituacaoAtualRepository situRepo;

    @GetMapping("/situacaoAtual")
    public List<SituacaoAtual> findSituacaoAtual() {
        System.out.println("findSituacaoAtual invoado");
        return (List<SituacaoAtual>) situRepo.findAll();
    }
    
}