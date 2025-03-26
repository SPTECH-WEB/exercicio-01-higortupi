package com.faturas.controller;

import com.faturas.Model.Fatura;
import com.faturas.repository.FaturaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    FaturaRepository faturaRepository;

    public FaturaController(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    @PostMapping
    public void cadastrarFaturas(@Valid @RequestBody Fatura fatura) {
        faturaRepository.save(fatura);
    }

    @GetMapping
    public List<Fatura> listarFaturas() {
        return faturaRepository.findAll();
    }
}
