package com.example.everis.controleSaque.Controller;

import com.example.everis.controleSaque.Model.ContaModel;
import com.example.everis.controleSaque.Repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Service
@RequestMapping(path = "/conta")
public class QtdSaquesController {
    @Autowired
    private ContaRepository repository;

    @PostMapping(path = "/{cpf}")
    public String alterarQtdSaquesBanco(@PathVariable(value = "cpf") String cpf) {
        Optional<ContaModel> busca = repository.findByCpf(cpf);
        if (busca.isPresent()) {
            busca.map(map -> {
                map.setQtdsaques(map.getQtdsaques() + 1);
                ContaModel updated = repository.save(map);
                return ResponseEntity.ok().body(updated);
            });
            return"Salvo"+ResponseEntity.ok().build();
        }
        return "Não foi Salvo"+ResponseEntity.badRequest().build();
    }
}
