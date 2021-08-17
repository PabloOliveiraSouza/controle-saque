package com.example.everis.controleSaque.Repository;


import com.example.everis.controleSaque.Model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ContaRepository extends JpaRepository<ContaModel, Integer> {
     Optional<ContaModel> findByCpf (String cpf);


}
